package mk.finki.ukim.mk.lab.service.impl;

import mk.finki.ukim.mk.lab.model.Order;
import mk.finki.ukim.mk.lab.repository.OrderRepositoryInterface;
import mk.finki.ukim.mk.lab.service.OrderServiceInterface;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderServiceInterface {
    private OrderRepositoryInterface orderRepository;

    OrderServiceImpl(OrderRepositoryInterface orderRepository){
        this.orderRepository = orderRepository;
    }
    @Override
    public Order placeOrder(String pizzaType, String clientName, String address) {
        return orderRepository.addOrder(pizzaType, clientName, address);
    }
}
