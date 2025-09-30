package com.jpa.cache.RedisCacheLearning.controller;

import com.jpa.cache.RedisCacheLearning.entity.Product;
import com.jpa.cache.RedisCacheLearning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")

public class RedisCacheController {


    @Autowired
    private ProductService productService;

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
        return productService.getProductList();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id){
        return productService.getProductById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable int id){
        productService.deleteProductById(id);
    }
}
