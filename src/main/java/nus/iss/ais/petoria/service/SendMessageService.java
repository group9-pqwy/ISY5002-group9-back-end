package nus.iss.ais.petoria.service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;

/**
 * This interface defines a service for sending messages via a chatbot.
 * It provides methods to send normal messages and feedback messages with interactive buttons.
 */
public interface SendMessageService {

    /**
     * Creates and returns a normal text message to be sent to the specified chat.
     *
     * @param chatId The unique identifier of the chat where the message will be sent.
     * @param text The content of the message to be sent.
     * @return A {@link SendMessage} object containing the chat ID and message text.
     */
    SendMessage setNormalMessage(String chatId, String text);

    /**
     * Creates and returns a feedback message with two buttons, each with an associated callback.
     * The buttons allow users to provide feedback, such as selecting between two options.
     *
     * @param chatId The unique identifier of the chat where the message will be sent.
     * @param text The content of the message to be sent.
     * @param buttonA The label for the first feedback button.
     * @param callbackOfButtonA The callback data for the first feedback button when clicked.
     * @param buttonB The label for the second feedback button.
     * @param callbackOfButtonB The callback data for the second feedback button when clicked.
     * @return A {@link SendMessage} object containing the chat ID, message text, and feedback buttons.
     */
    SendMessage sendFeedbackMessage(String chatId, String text, String buttonA, String callbackOfButtonA, String buttonB, String callbackOfButtonB);

}
