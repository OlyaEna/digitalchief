package com.digitalchief.model.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(columnDefinition = "text")
    private String description;
    private String ISBN;
    @Column(name = "release_date")
    private Date releaseDate;
    @ManyToMany(mappedBy = "products")
    private List<Author> authors;
    @ManyToMany(mappedBy = "products")
    private List<Genre> genre;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="publisher_id")
    private Publisher publisher;
}
