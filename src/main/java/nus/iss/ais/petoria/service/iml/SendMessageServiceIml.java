package nus.iss.ais.petoria.service.iml;

import lombok.extern.slf4j.Slf4j;
import nus.iss.ais.petoria.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
@Slf4j
public class SendMessageServiceIml implements SendMessageService {
    //@Override
    //    public void onUpdateReceived(Update update) {
    //        String chatId = update.getMessage().getChatId().toString();
    //        if (update.hasMessage() && update.getMessage().hasPhoto()) {
    //            String pictureId = pictureService.getPictureIdFromTelegram(update);
    //
    //            try {
    //                String pictureURl = pictureService.getPicturePath(pictureId);
    //                String petBreed = pictureService.downloadAndSendToFlask(pictureURl);
    //                SendMessage message = new SendMessage();
    //                message.setChatId(chatId);
    //                message.setText("识别结果: " + petBreed);
    //                execute(message);
    //            } catch (Exception e) {
    //                throw new RuntimeException(e);
    //            }
    //        }
    //        else {
    //            SendMessage message1 = new SendMessage();
    //            message1.setChatId(chatId);
    //            message1.setText("你发送的消息里不包括图片哦！");
    //            try {
    //                execute(message1);
    //            } catch (TelegramApiException e) {
    //                throw new RuntimeException(e);
    //            }
    //        }
    @Override
    public SendMessage setNormalMessage(String chatId, String text) {
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(text);
            return message;
    }

    @Override
    public SendMessage sendFeedbackMessage(String chatId, String text) {

        return null;
    }
}

