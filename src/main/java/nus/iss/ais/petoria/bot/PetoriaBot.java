package nus.iss.ais.petoria.bot;

import lombok.extern.slf4j.Slf4j;
import nus.iss.ais.petoria.config.TelegramBotConfig;
import nus.iss.ais.petoria.service.PictureService;
import nus.iss.ais.petoria.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

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
        String chatId = update.getMessage().getChatId().toString();
                if (update.hasMessage() && update.getMessage().hasPhoto()) {
                    sendPetBreed(pictureService.getPictureIdFromTelegram(update),chatId);
                }
                else {
                    executeSendMessage(sendMessageService.setNormalMessage(chatId,"The message you sent didn't include a picture."));
                }
    }

    private void sendPetBreed(String pictureId,String chatId)
    {
        try {
            String pictureURl = pictureService.getPicturePath(pictureId);
            String petBreed = pictureService.downloadAndSendToFlask(pictureURl);
            execute(sendMessageService.setNormalMessage(chatId,petBreed));
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
}