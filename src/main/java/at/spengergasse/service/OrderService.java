package at.spengergasse.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.stream.Collectors;

import com.github.javafaker.Faker;

import at.spengergasse.domain.Order;

public class OrderService{

    private ArrayList<Order> orders;

    public OrderService(){
        orders = new ArrayList<>(1000);
        fillTestData(500);
    }

    public void fillTestData(int amount){
        Faker faker;
        Order order;
        LocalDate orderDate; // time of order
        String movie; // movie name
        String seat; //front, back, middle
        Integer quantity; //amount of tickets ordered
        Double price; // price of a ticket
        Boolean drink; //drink ordered
        String[] MOVIES = {"Mad Max", "The Dark Knight", "Matrix", "Lord of the Rings", "Harry Potter"};
        String[] SEATS = {"Front", "Back", "Middle"};

        faker = new Faker();
        orders.clear();

        for (int i = 0; i < amount; i++) {

            orderDate = LocalDate.now().minusDays((int) (Math.random() * 365 * 10));
            movie = MOVIES[faker.number().numberBetween(0, MOVIES.length-1)];
            seat = SEATS[faker.number().numberBetween(0, SEATS.length-1)];
            quantity = faker.number().numberBetween(1, 5);
            price = faker.number().randomDouble(2, 10, 50);
            drink = faker.bool().bool();

            order = new Order(orderDate, movie, seat, quantity, price, drink);
            orders.add(order);
        }
    }

    @Override
    public String toString(){
        return orders.stream()
            .map(o -> o.toString())
            .collect(Collectors.joining("\n"));
    }
}
