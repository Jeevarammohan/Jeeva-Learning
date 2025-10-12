package com.learning.Flyway.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "REGISTRATION_USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String mobileNo;

}
