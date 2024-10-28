package nus.iss.ais.petoria.model;
import lombok.Data;

import java.util.List;

public class DogBreedPrediction {
    private String message;
    private String breedType;
    private String purebredPrediction;
    private List<String> mixedBreedPrediction;

    // Getters and Setters
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getBreedType() { return breedType; }
    public void setBreedType(String breedType) { this.breedType = breedType; }

    public String getPurebredPrediction() { return purebredPrediction; }
    public void setPurebredPrediction(String purebredPrediction) { this.purebredPrediction = purebredPrediction; }

    public List<String> getMixedBreedPrediction() { return mixedBreedPrediction; }
    public void setMixedBreedPrediction(List<String> mixedBreedPrediction) { this.mixedBreedPrediction = mixedBreedPrediction; }
}
