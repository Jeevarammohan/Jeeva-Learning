package com.learning_spring_boot.myfirstwebapp.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="TODO")
public class ToDo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String userName;
    @NotBlank(message = "Description is required")
    @Size(min = 10,message = "Enter at least 10 characters")
    private String description;
    @NotNull(message = "Target Date is required")
    private LocalDate targetDate;

    private  boolean isDone;

    public ToDo(String userName, String description, LocalDate targetDate, Boolean done) {
        this.userName = userName;
        this.description = description;
        this.targetDate = targetDate;
        this.isDone = done;
    }
}
