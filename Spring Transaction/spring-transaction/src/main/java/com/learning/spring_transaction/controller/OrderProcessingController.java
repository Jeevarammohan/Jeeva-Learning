package com.learning.spring_transaction.controller;

import com.learning.spring_transaction.model.Order;
import com.learning.spring_transaction.service.OrderProcessingService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-processing-controller")
@Tag(name = "Orders", description = "Order processing APIs")  // Swagger tag
public class OrderProcessingController {
    private final OrderProcessingService  orderProcessingService;

    public OrderProcessingController(OrderProcessingService orderProcessingService) {
        this.orderProcessingService = orderProcessingService;
    }

    @PostMapping("/placeOrder")
    @Operation(summary = "Place a new order")
    public ResponseEntity<?> processOrder(@RequestBody Order order) {
        return new ResponseEntity<>(orderProcessingService.placeOrder(order), HttpStatus.OK);
    }

}
