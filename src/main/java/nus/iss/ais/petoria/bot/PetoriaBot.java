package nus.iss.ais.petoria.bot;

import lombok.extern.slf4j.Slf4j;
import nus.iss.ais.petoria.config.TelegramBotConfig;
import nus.iss.ais.petoria.service.GeminiChatService;
import nus.iss.ais.petoria.service.LoggingService;
import nus.iss.ais.petoria.service.PictureService;
import nus.iss.ais.petoria.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;
import java.util.Random;

@Controller
@Slf4j
public class PetoriaBot extends TelegramLongPollingBot {
    @Autowired
    private TelegramBotConfig telegramBotConfig;
    @Autowired
    private PictureService pictureService;
    @Autowired
    private SendMessageService sendMessageService;
    @Autowired
    private KafkaTemplate<String, Update> kafkaTemplate;
    @Autowired
    private LoggingService loggingService;
    @Autowired
    private GeminiChatService geminiChatService;

    @Override
    public String getBotUsername() {
        return telegramBotConfig.getUsername();
    }

    @Override
    public String getBotToken() {
        return telegramBotConfig.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        kafkaTemplate.send("update_topic", update);
    }

    @KafkaListener(topics = "update_topic", groupId = "telegram-bot-group",concurrency = "3")
    public void processUpdate(Update update) {
                if (update.hasMessage() && update.getMessage().hasPhoto()) {
                    String chatId = update.getMessage().getChatId().toString();
                    int recordId=sendPetBreed(pictureService.getPictureIdFromTelegram(update),chatId);
                    randomSendQuery(100,chatId,"Do you think the predictions are good? (>^ω^<)","Yes","goodPredict|"+recordId,"No","badPredict|"+recordId);
                }
                else if (update.hasCallbackQuery()){
                    setFeedbackState(update);
                }
                else if (update.hasMessage() && update.getMessage().hasText()) {
                    String chatId = update.getMessage().getChatId().toString();
                    String responseText = getMessage(update);
                    executeSendMessage(sendMessageService.setNormalMessage(chatId, responseText));
                }
                else {
                    String chatId = update.getMessage().getChatId().toString();
                    executeSendMessage(sendMessageService.setNormalMessage(chatId,"The message you sent didn't include a picture or text. You can send me a picture of the dog and I'll help you identify its breed!"));
                }
    }

    private int sendPetBreed(String pictureId,String chatId)
    {
        try {
            String BOT_TOKEN = telegramBotConfig.getToken();
            String pictureURl = pictureService.getPicturePath(pictureId);
            String TELEGRAM_FILE_BASE_URL = "https://api.telegram.org/file/bot" + BOT_TOKEN + "/";
            String fileUrl = TELEGRAM_FILE_BASE_URL + pictureURl;
            List<String> petBreed = pictureService.downloadAndSendToFlask(pictureURl);

            execute(sendMessageService.setNormalMessage(chatId,"If this adorable little buddy is a purebred, then it’s a perfect little "+petBreed.get(0)+". But if it’s a mix, it’s probably got a charming blend of "+petBreed.get(1)+" and "+petBreed.get(2)+" in its family tree!"));
            return loggingService.insertPredictRecord(fileUrl,"b1"+petBreed.get(0)+"b2"+petBreed.get(1));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void executeSendMessage(SendMessage sendMessage)
    {
        try
        {
            execute(sendMessage);
        }
        catch (TelegramApiException e)
        {
            throw new RuntimeException(e);
        }
    }

    private void randomSendQuery(int percent,String chatId, String text,String buttonA,String callbackOfButtonA,String buttonB,String callbackOfButtonB)
    {
        Random random = new Random();
        int randomNum = random.nextInt(1,100)+1;
        if (randomNum<percent)
        {
            executeSendMessage(sendMessageService.sendFeedbackMessage(chatId,text,buttonA,callbackOfButtonA,buttonB,callbackOfButtonB));
        }
    }

    private void setFeedbackState(Update update)
    {
        CallbackQuery callbackQuery = update.getCallbackQuery();
        String data = callbackQuery.getData();
        String chatId = callbackQuery.getMessage().getChatId().toString();

        String[] parts = data.split("\\|");
        String action = parts[0];
        String recordId = parts.length > 1 ? parts[1] : null;

        if ("goodPredict".equals(action)) {
            if (recordId != null) {
                int id = Integer.parseInt(recordId);
                loggingService.updateFeedbackState(id, 1);
            }
            executeSendMessage(sendMessageService.setNormalMessage(chatId, "Thank you for your positive feedback!"));
        } else if ("badPredict".equals(action)) {
            if (recordId != null) {
                int id = Integer.parseInt(recordId);
                loggingService.updateFeedbackState(id, 2);
            }
            executeSendMessage(sendMessageService.setNormalMessage(chatId, "Thank you for your feedback. We'll work on improving."));
        } else {
            executeSendMessage(sendMessageService.setNormalMessage(chatId, "Invalid selection."));
        }
    }

    private String getMessage(Update update)
    {
        String inputText = update.getMessage().getText();
        return geminiChatService.chat(inputText);
    }
}