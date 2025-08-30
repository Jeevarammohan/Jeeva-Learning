package com.learning.spring_security.repo;

import com.learning.spring_security.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository

public interface UserRepo extends JpaRepository<Users, Integer> {
    Users findByUsername(String username);
}
