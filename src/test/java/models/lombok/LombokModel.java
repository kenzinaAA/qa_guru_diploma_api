package models.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import models.Resourse;
import models.User;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LombokModel {
    @JsonProperty("data")
    private User user;
    private Resourse resourse;
}
