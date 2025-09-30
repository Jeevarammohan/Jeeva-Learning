package com.jpa.mapping.JPALearning.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@Table(name = "manufactures")
@AllArgsConstructor
@NoArgsConstructor
public class Manufactures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(name = "manufacture_name")
    private String manufacturerName;

    @OneToMany(mappedBy = "manufacture", cascade = CascadeType.ALL)
    private List<Model> models;

    public Manufactures(String name) {
        this.manufacturerName = name;
    }
}
