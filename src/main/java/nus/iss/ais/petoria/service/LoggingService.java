package nus.iss.ais.petoria.service;

import org.apache.kafka.common.protocol.types.Field;

/**
 * This interface defines a service for logging and updating records related to image recognition.
 * It provides methods to insert a prediction record and update feedback state for a given record.
 */
public interface LoggingService {

    /**
     * Inserts a prediction record into the database with the given image URL and recognition result.
     *
     * @param imageUrl The URL of the image.
     * @param recognitionResult The recognition result for the image, such as predicted dog breeds.
     * @return The ID of the inserted record in the database.
     */
    int insertPredictRecord(String imageUrl, String recognitionResult);

    /**
     * Updates the feedback state of a prediction record in the database.
     *
     * @param id The unique ID of the prediction record to update.
     * @param state The new feedback state to set (e.g., 0, 1,2).
     */
    void updateFeedbackState(int id, int state);
}