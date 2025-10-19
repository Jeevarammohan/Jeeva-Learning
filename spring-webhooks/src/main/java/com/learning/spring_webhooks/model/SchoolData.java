package com.learning.spring_webhooks.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "school_data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String schoolName;
    @OneToMany(mappedBy = "schoolData",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<WebhookDetails> webhookDetails;
    @OneToMany(mappedBy = "schoolData",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Student> students;
}
