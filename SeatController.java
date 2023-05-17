package cinema;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class SeatController {
    @Autowired
    public CinemaRoom room;
    @Autowired
    public PurchasedTickets list;

    @GetMapping("/seats")
    public String returnSeats() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        String seats = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(room);

        return seats;
    }

    @PostMapping("/purchase")
    public String purchaseSeat(@RequestBody SeatInfo info) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        if(room.getRows() < info.getRow() || room.getColumns() < info.getColumn() || info.getRow()<=0 || info.getColumn()<=0) {
            throw new OutOfBoundException();
        }
        Seat seat = room.getSeat(info.getRow(), info.getColumn());

        if(!seat.isAvailable()){
            throw new AlreadyPurchasedException();
        }
        Purchase purchase = new Purchase(UUID.randomUUID().toString(), seat);
        String output = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(purchase);
        seat.selectSeat();
        list.addTicket(purchase);

        return output;
    }

    @PostMapping("/return")
    public String returnSeat(@RequestBody Token token) throws JsonProcessingException {
        if(!list.isSold(token.getToken())){
            throw new WrongToken();
        }
        ReturnedTicket ticket = new ReturnedTicket(list.getSeat(token.getToken()));

        ObjectMapper objectMapper = new ObjectMapper();
        String output = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(ticket);
        list.returnTicket(token.getToken());
        return output;


    }

    @PostMapping("/stats")
    public ResponseEntity<Object> statSummary(@RequestParam(required = false) String password){
        if(password == null || !password.equals("super_secret")){
            return new ResponseEntity<>(Map.of("error", "The password is wrong!"), HttpStatus.UNAUTHORIZED);
        }

        Map<String, Integer> summary = new HashMap<>();
        summary.put("current_income", list.currentIncome());
        summary.put("number_of_available_seats", room.getColumns()* room.getRows()- list.numberOfPurchases());
        summary.put("number_of_purchased_tickets", list.numberOfPurchases());
        return new ResponseEntity<>(summary, HttpStatus.OK);

    }
}
