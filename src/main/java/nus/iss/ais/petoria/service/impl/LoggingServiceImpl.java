package nus.iss.ais.petoria.service.impl;

import lombok.extern.slf4j.Slf4j;
import nus.iss.ais.petoria.mapper.PictureEvaluationMapper;
import nus.iss.ais.petoria.model.PictureEvaluation;
import nus.iss.ais.petoria.service.LoggingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class LoggingServiceImpl implements LoggingService {
    @Autowired
    private PictureEvaluationMapper pictureEvaluationMapper;

    @Override
    public int insertPredictRecord(String imageUrl,String recognitionResult) {
        PictureEvaluation pictureEvaluation = new PictureEvaluation();
        pictureEvaluation.setRecordTime(new java.sql.Date(System.currentTimeMillis()));
        pictureEvaluation.setImageUrl(imageUrl);
        pictureEvaluation.setBreedRecognitionResult(recognitionResult);
        pictureEvaluation.setUserFeedback(0);

        pictureEvaluationMapper.insertSelective(pictureEvaluation);

        int generatedId = pictureEvaluation.getId();
        return generatedId;
    }

    @Override
    public void updateFeedbackState(int id, int state) {
        PictureEvaluation pictureEvaluation = new PictureEvaluation();
        pictureEvaluation.setId(id);
        pictureEvaluation.setUserFeedback(state);
        pictureEvaluationMapper.updateByPrimaryKeySelective(pictureEvaluation);
    }


}
