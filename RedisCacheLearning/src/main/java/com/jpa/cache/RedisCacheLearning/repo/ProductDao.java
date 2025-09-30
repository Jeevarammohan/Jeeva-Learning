package com.jpa.cache.RedisCacheLearning.repo;

import com.jpa.cache.RedisCacheLearning.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductDao {

    public static final String HASH_KEY = "Product";
    @Autowired
    private RedisTemplate  template;

    public Product save(Product product){
        template.opsForHash().put(HASH_KEY,product.getId(),product);
        return product;
    }

    public List<Product> getAllProducts(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Product getProductById(int id){
        System.out.println("Call to DB");
        return  (Product) template.opsForHash().get(HASH_KEY,id);
    }

    public Long deleteProductById(int id){
        return template.opsForHash().delete(HASH_KEY,id);
    }
}
