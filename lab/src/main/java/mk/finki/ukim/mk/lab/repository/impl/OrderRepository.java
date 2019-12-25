package mk.finki.ukim.mk.lab.repository.impl;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepositoryInterface;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Repository
public class OrderRepository implements OrderRepositoryInterface {
    private static final List<Order> orders = new ArrayList<>();
    public List<Order> getOrders() {
        return orders;
    }
    public Order addOrder(String pizzaType, String clientName, String address){
        Order newOrder = new Order(pizzaType, clientName, address, new Random().nextLong());
        orders.add(newOrder);
        return newOrder;
    }

}
