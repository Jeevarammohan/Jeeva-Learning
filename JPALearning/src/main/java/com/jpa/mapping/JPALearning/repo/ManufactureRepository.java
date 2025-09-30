package com.jpa.mapping.JPALearning.repo;

import com.jpa.mapping.JPALearning.model.Manufactures;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufactures, Integer> {
}
