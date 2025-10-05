package com.jpa.cache.RedisMySQLCacheLearning.repo;

import com.jpa.cache.RedisMySQLCacheLearning.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<Movie,Integer> {
}
