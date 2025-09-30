package com.jpa.cache.RedisCacheLearning.service;

import com.jpa.cache.RedisCacheLearning.entity.Product;
import com.jpa.cache.RedisCacheLearning.repo.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    @Cacheable(key="#id",value = "Product", unless = "#result != null || #result.productPrice < 10000")
    public Product getProductById(int id){
        return productDao.getProductById(id);
    }

    public Product saveProduct(Product product){
        return productDao.save(product);
    }
    public List<Product> getProductList(){
        return productDao.getAllProducts();
    }

    public Long deleteProductById(int id){
        return productDao.deleteProductById(id);
    }
}
