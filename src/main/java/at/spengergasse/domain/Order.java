package at.spengergasse.domain;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
//@NoArgsConstructor
//@AllArgsConstructor
@ToString
@Entity
public class Order implements Cloneable{

    @Id
    private Long orderId;
    private LocalDate orderDate; // time of order
    private String movie; // movie name
    private String seat; //front, back, middle
    private Integer quantity; //amount of tickets ordered
    private Double price; // price of a ticket
    private Boolean drinks; //drinks ordered

    private static final AtomicLong sequence = new AtomicLong(1000);
    private static final String[] seats = {"Front","Middle","Back"};

    public Order(Long orderId, LocalDate orderDate, String movie, String seat, Integer quantity, Double price,
            Boolean drinks){
        setOrderId (orderId);
        setOrderDate (orderDate);
        setMovie (movie);
        setSeat (seat);
        setQuantity (quantity);
        setPrice (price);
        setDrinks (drinks);
    }

    public Order(LocalDate orderDate, String movie, String seat, Integer quantity, Double price,
            Boolean drinks) {
        setOrderId ();
        setOrderDate (orderDate);
        setMovie (movie);
        setSeat (seat);
        setQuantity (quantity);
        setPrice (price);
        setDrinks (drinks);
    }

    public Order(){

    }

    public void setOrderId(){
        orderId = sequence.getAndIncrement();
    }

    public void setPrice(Double price){
        if (price.doubleValue() < 5){
            throw new OrderException("Price to low!");
        }
        this.price = price;
    }

    public void setSeat(String seat){
        if (! Arrays.asList(seats).contains(seat)){
            throw new OrderException("Wrong seat");
        }
        this.seat = seat;
    }

    // Clone-Method
    @Override
    public Order clone(){
        return new Order(orderId, orderDate, movie, seat, quantity, price, drinks);
    }

}
