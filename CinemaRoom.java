package cinema;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CinemaRoom {
    @JsonProperty("total_rows")
    private int rows;
    @JsonProperty("total_columns")
    private int columns;

    @JsonProperty("available_seats")
    private ArrayList<Seat> seats;

    public CinemaRoom(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        seats = new ArrayList<>();
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<columns; j++){
                seats.add(new Seat(i+1, j+1));
            }
        }
    }

    public CinemaRoom(){
        this(9,9);
    }

    public Seat getSeat(int row, int column){
        for(Seat seat : this.seats){
            if(seat.getRow() == row && seat.getColumn() == column){
                return seat;
            }
        }
        return null;
    }

    public int getRows() {
        return this.rows;
    }

    public int getColumns() {
        return this.columns;
    }
}
