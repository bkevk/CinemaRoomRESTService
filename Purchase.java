package cinema;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Purchase {
    private String token;
    @JsonProperty("ticket")
    private Seat seat;

    public Purchase(String token, Seat seat){
        this.seat = seat;
        this.token = token;


    }

    public Seat getSeat() {
        return seat;
    }

    public String getToken() {
        return token;
    }


}
