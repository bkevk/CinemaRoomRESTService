package cinema;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Seat {
    private int row;
    private int column;
    private int price;
    @JsonIgnore
    private boolean available;

    public Seat(int row, int column){
        this.row = row;
        this.column = column;
        this.price = row<=4?10:8;
        this.available = true;
    }

    public int getRow(){
        return this.row;
    }

    public int getColumn(){
        return this.column;
    }

    public void selectSeat(){
        this.available = false;
    }
    public boolean isAvailable(){
        return this.available;
    }

    public int getPrice() {
        return price;
    }
}
