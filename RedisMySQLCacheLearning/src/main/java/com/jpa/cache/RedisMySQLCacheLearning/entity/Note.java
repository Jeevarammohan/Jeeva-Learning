package com.jpa.cache.RedisMySQLCacheLearning.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "stream_note")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Note implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private Date created;
    private boolean live=false;
}
