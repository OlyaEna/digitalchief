package com.digitalchief.model.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name="series_id")
    private Series series;
}
