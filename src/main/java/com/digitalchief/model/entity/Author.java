package com.digitalchief.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "birth_date")
    private Date birthDate;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "author_product",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

}
