package com.learning.spring_transaction.handler;

import com.learning.spring_transaction.model.Order;
import com.learning.spring_transaction.model.Product;
import com.learning.spring_transaction.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class InventoryHandler {

    private final InventoryRepository inventoryRepository;
    public InventoryHandler(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public void saveProduct(Product product){
        if(product.getPrice()>5000){
            throw new RuntimeException("DB crashed.....");
        }
        inventoryRepository.save(product);
    }

    public Product getProduct(int id){
        List<Order> list = new ArrayList<>();
        list.add(new Order());
        list.sort(Comparator.comparing(Order::getQuantity).thenComparing(Order::getTotalPrice).reversed());
        return inventoryRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Product not found"));
    }


}
