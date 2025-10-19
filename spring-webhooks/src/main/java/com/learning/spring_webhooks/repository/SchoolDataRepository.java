package com.learning.spring_webhooks.repository;

import com.learning.spring_webhooks.model.SchoolData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolDataRepository extends JpaRepository<SchoolData, Integer> {
}
