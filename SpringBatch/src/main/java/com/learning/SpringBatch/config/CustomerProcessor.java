package com.learning.SpringBatch.config;

import com.learning.SpringBatch.model.Customer;
import org.springframework.batch.item.ItemProcessor;

public class CustomerProcessor implements ItemProcessor<Customer, Customer> {
    @Override
    public Customer process(Customer item) throws Exception {
        return item;
    }
}
