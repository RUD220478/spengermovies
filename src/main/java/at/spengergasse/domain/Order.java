package at.spengergasse.domain;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Order {

    @Id
    private Long orderId;
    private LocalDate orderDate; // time of order
    private String movie; // movie name
    private String seat; //front, back, middle
    private Integer quantity; //amount of tickets sold
    private Boolean drinks; //drinks bought

    

    private static final AtomicLong sequence = new AtomicLong(1000);

    public void setOrderId(){
        orderId = sequence.getAndIncrement();
    }

}
