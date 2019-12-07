package cardealershop.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class VinModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonProperty("vin")
    private String vin;
    @JsonProperty("year")
    private String year;
    @JsonProperty("make")
    private String make;
    @JsonProperty("model")
    private String model;
    @JsonProperty("style")
    private String style;
    @JsonProperty("engine")
    private String engine;
    @JsonProperty("made_in")
    private String madeIn;
    @JsonProperty("steering_type")
    private String steeringType;
    @JsonProperty("standard_seating")
    private String standardSeating;


}
