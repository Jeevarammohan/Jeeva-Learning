package com.learning.spring_transaction.handler;

import com.learning.spring_transaction.model.Order;
import com.learning.spring_transaction.repository.OrderRepository;
import org.springframework.stereotype.Service;

@Service
public class OrderHandler {

    private final OrderRepository orderRepository;

    public OrderHandler(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }
}
