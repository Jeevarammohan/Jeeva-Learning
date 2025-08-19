package com.learning.spring_boot.controller;

import com.learning.spring_boot.configuration.CurrencyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyController {

    @Autowired
    private CurrencyConfiguration currencyConfiguration;
    @GetMapping("/currency-configuration")
    public CurrencyConfiguration getCourse(){

        return currencyConfiguration;
    }
}
