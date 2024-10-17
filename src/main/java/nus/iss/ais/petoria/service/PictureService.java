package nus.iss.ais.petoria.service;

import org.telegram.telegrambots.meta.api.objects.Update;

import java.util.List;

/**
 * PictureService interface defines methods for handling image-related operations
 * with the Telegram bot, including extracting the image ID, retrieving the image path,
 * and sending the image to a Flask service for further processing.
 */
public interface PictureService {

    /**
     * Extracts the file ID of the image from the Telegram update object.
     *
     * @param update Telegram update object containing the message details
     * @return the file ID of the image
     */
    String getPictureIdFromTelegram(Update update);

    /**
     * Retrieves the file path of an image from Telegram based on the provided file ID.
     *
     * @param pictureId the file ID of the image in Telegram
     * @return the file path of the image
     * @throws Exception if there is an issue while retrieving the file path
     */
    String getPicturePath(String pictureId) throws Exception;

    /**
     * Downloads the image using its file path and sends it to a Flask service for processing.
     *
     * @param filePath the file path of the image in Telegram
     * @return the response from the Flask service after processing the image
     * @throws Exception if there is an issue during the download or sending process
     */
    List<String> downloadAndSendToFlask(String filePath) throws Exception;

}
