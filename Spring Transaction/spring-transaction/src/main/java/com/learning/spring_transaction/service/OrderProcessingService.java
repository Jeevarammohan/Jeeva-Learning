package com.learning.spring_transaction.service;

import com.learning.spring_transaction.handler.InventoryHandler;
import com.learning.spring_transaction.handler.OrderHandler;
import com.learning.spring_transaction.model.Order;
import com.learning.spring_transaction.model.Product;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderProcessingService {

    private final OrderHandler orderHandler;
    private final InventoryHandler inventoryHandler;

    public OrderProcessingService(OrderHandler orderHandler, OrderHandler orderHandler1, InventoryHandler inventoryHandler) {
        this.orderHandler = orderHandler1;
        this.inventoryHandler = inventoryHandler;
    }

    @Transactional(readOnly = false,propagation = Propagation.REQUIRED,isolation = Isolation.READ_COMMITTED)
    public Order placeOrder(Order order){
        Product product=inventoryHandler.getProduct(order.getProductId());
        validateStockAvailability(order, product);
        order.setTotalPrice(product.getPrice()*order.getQuantity());
        Order saveOrder=orderHandler.saveOrder(order);
        updateInventoryStock(order, product);
        return saveOrder;
    }

    private static void validateStockAvailability(Order order, Product product) {
        if(order.getQuantity()> product.getStockQuantity()){
            throw new RuntimeException("Insufficient stock");
        }
    }

    private void updateInventoryStock(Order order, Product product) {
        int availableQuantity= product.getStockQuantity()- order.getQuantity();
        product.setStockQuantity(availableQuantity);
        inventoryHandler.saveProduct(product);
    }
}
