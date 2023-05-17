package cinema;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CinemaError {
    private String error;
    public CinemaError(String message){
        this.error = message;
    }
}
