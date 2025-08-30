package com.learning.spring_security.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Users {
    @Id
    private Integer id;
    private String username;
    private String password;



}
