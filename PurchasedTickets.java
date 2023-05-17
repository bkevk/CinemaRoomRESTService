package cinema;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PurchasedTickets {
    private Map<String, Seat> list;

    public PurchasedTickets(){
        this.list = new HashMap<>();
    }

    public void addTicket(Purchase purchase){
        list.put(purchase.getToken(), purchase.getSeat());
    }

    public void returnTicket(String token){
        list.remove(token);
    }

    public boolean isSold(String token){
        return this.list.containsKey(token);
    }

    public Seat getSeat(String token){
        return this.list.get(token);
    }

    public int currentIncome(){
        int sum = 0;
        for(String id : list.keySet()){
            sum += list.get(id).getPrice();
        }
        return sum;
    }

    public int numberOfPurchases(){
        return this.list.size();
    }
}
