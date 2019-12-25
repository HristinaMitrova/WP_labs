package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Order;

public interface OrderServiceInterface {
    Order placeOrder(String pizzaType, String clientName, String address);

}
