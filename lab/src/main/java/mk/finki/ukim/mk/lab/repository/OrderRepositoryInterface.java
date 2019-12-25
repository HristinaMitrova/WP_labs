package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Order;

import java.util.List;

public interface OrderRepositoryInterface {
    List<Order> getOrders();
    Order addOrder(String pizzaType, String clientName, String address);
}
