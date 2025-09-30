package com.jpa.mapping.JPALearning.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="model")
@AllArgsConstructor
@NoArgsConstructor
public class Model {
    @Id
    private int model_id;
    private String model_name;

    @ManyToOne
    @JoinColumn(name = "manufacture_id")
    private Manufactures manufacture;

}
