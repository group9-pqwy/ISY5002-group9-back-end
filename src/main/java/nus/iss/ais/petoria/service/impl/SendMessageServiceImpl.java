package nus.iss.ais.petoria.service.impl;

import lombok.extern.slf4j.Slf4j;
import nus.iss.ais.petoria.service.SendMessageService;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class SendMessageServiceImpl implements SendMessageService {
    @Override
    public SendMessage setNormalMessage(String chatId, String text) {
            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText(text);
            return message;
    }

    @Override
    public SendMessage sendFeedbackMessage(String chatId, String text,String buttonA,String callbackOfButtonA,String buttonB,String callbackOfButtonB) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText(text);
        InlineKeyboardButton goodButton = new InlineKeyboardButton();
        goodButton.setText(buttonA);
        goodButton.setCallbackData(callbackOfButtonA);

        InlineKeyboardButton badButton = new InlineKeyboardButton();
        badButton.setText(buttonB);
        badButton.setCallbackData(callbackOfButtonB);

        List<InlineKeyboardButton> row = new ArrayList<>();
        row.add(goodButton);
        row.add(badButton);

        List<List<InlineKeyboardButton>> keyboard = new ArrayList<>();
        keyboard.add(row);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        inlineKeyboardMarkup.setKeyboard(keyboard);
        message.setReplyMarkup(inlineKeyboardMarkup);
        return message;
    }
}

