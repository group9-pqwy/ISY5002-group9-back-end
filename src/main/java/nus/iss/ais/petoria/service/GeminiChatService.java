package nus.iss.ais.petoria.service;

/**
 * This interface defines a service for interacting with the Gemini chatbot.
 * It provides a method for sending input text to the chatbot and receiving a response.
 */
public interface GeminiChatService {

    /**
     * Sends the provided input text to the Gemini chatbot and returns the chatbot's response.
     *
     * @param inputText The input text to send to the chatbot.
     * @return A response string from the Gemini chatbot.
     */
    String chat(String inputText);
}
