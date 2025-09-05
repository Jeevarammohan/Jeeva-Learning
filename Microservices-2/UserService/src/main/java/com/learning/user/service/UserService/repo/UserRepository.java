package com.learning.user.service.UserService.repo;

import com.learning.user.service.UserService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
