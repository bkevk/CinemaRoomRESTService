package cinema;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class SeatInfo {
    private int row;
    private int column;

    public SeatInfo(){

    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
