package com.jpa.mapping.JPALearning.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String address;
}
