package nus.iss.ais.petoria.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

public interface SendMessageService {
    SendMessage setNormalMessage(String chatId, String text);

    SendMessage sendFeedbackMessage(String chatId, String text,String buttonA,String callbackOfButtonA,String buttonB,String callbackOfButtonB);


}
