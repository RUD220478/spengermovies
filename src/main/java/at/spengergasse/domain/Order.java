package at.spengergasse.domain;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicLong;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Entity
public class Order implements Cloneable {

    @Id
    private Long orderId;
    private LocalDate orderDate;
    private String movie;
    private String seat;
    private Integer quantity;
    private Double price;
    private Boolean drink;

    private static final AtomicLong sequence = new AtomicLong(1000);
    private static final String[] seats = {"Front", "Middle", "Back"};

    public Order(Long orderId,
                 LocalDate orderDate,
                 String movie,
                 String seat,
                 Integer quantity,
                 Double price,
                 Boolean drink) {

        setOrderId(orderId);
        setOrderDate(orderDate);
        setMovie(movie);
        setSeat(seat);
        setQuantity(quantity);
        setPrice(price);
        setDrink(drink);
    }

    public Order(LocalDate orderDate,
                 String movie,
                 String seat,
                 Integer quantity,
                 Double price,
                 Boolean drink) {

        setOrderId();
        setOrderDate(orderDate);
        setMovie(movie);
        setSeat(seat);
        setQuantity(quantity);
        setPrice(price);
        setDrink(drink);
    }

    public Order() {
    }

    // automatische ID
    public void setOrderId() {
        this.orderId = sequence.getAndIncrement();
    }

    // manuelle ID
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDrink(Boolean drink) {
        this.drink = drink;
    }

    public void setPrice(Double price) {
        if (price == null || price < 5) {
            throw new OrderException("Price too low!");
        }
        this.price = price;
    }

    public void setSeat(String seat) {
        if (!Arrays.asList(seats).contains(seat)) {
            throw new OrderException("Wrong seat!");
        }
        this.seat = seat;
    }

    @Override
    public Order clone() {
        return new Order(
                orderId,
                orderDate,
                movie,
                seat,
                quantity,
                price,
                drink
        );
    }
}