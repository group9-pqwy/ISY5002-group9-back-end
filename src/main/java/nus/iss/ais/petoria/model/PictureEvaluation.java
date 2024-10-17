package nus.iss.ais.petoria.model;

import java.util.Date;

public class PictureEvaluation {
    private Integer id;

    private Date recordTime;

    private String imageUrl;

    private String breedRecognitionResult;

    private Integer userFeedback;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getBreedRecognitionResult() {
        return breedRecognitionResult;
    }

    public void setBreedRecognitionResult(String breedRecognitionResult) {
        this.breedRecognitionResult = breedRecognitionResult;
    }

    public Integer getUserFeedback() {
        return userFeedback;
    }

    public void setUserFeedback(Integer userFeedback) {
        this.userFeedback = userFeedback;
    }
}