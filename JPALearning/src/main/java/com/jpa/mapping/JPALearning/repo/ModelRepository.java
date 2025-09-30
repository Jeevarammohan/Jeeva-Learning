package com.jpa.mapping.JPALearning.repo;

import com.jpa.mapping.JPALearning.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model,Integer> {
}
