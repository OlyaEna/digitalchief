package com.digitalchief.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;

@Getter
@Setter
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
    @JsonManagedReference
    private List<Author> authors;
    @ManyToMany(mappedBy = "products")
    @JsonManagedReference
    private List<Genre> genre;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="publisher_id")
    @JsonManagedReference
    private Publisher publisher;

}
