package com.digitalchief.model.repository;

import com.digitalchief.model.entity.Genre;
import com.digitalchief.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByTitle(String name);

    @Query(value = "select * from digital_chief.products p where exists (select* from digital_chief.genres g join " +
            "digital_chief.genre_product gp on p.id=gp.product_id where gp.genre_id = g.id and g.name=:genre)", nativeQuery = true)
    List<Product> findByGenre(@Param("genre") String genre);
}
