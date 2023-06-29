package com.digitalchief.model.repository;

import com.digitalchief.model.entity.Genre;
import com.digitalchief.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByTitle(String name);
    List<Product> findProductsByGenre(Genre genre);

}
