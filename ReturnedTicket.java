package cinema;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ReturnedTicket {
    @JsonProperty("returned_ticket")
    private Seat seat;

    public ReturnedTicket(Seat seat){
        this.seat = seat;
    }

}
