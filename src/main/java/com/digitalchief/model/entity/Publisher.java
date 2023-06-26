package com.digitalchief.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "publishes")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
}
