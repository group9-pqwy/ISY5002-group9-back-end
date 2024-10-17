package nus.iss.ais.petoria.service;

import org.apache.kafka.common.protocol.types.Field;

public interface LoggingService {
    int insertPredictRecord(String imageUrl,String recognitionResult);
    void updateFeedbackState(int id,int state);
}