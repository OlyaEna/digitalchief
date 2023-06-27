package com.digitalchief.model.repository;

import com.digitalchief.model.entity.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
    Genre findByName(String name);
    @Modifying
    @Transactional
    @Query(value = "insert into digital_chief.genre_product values(:genreId, :productId)", nativeQuery = true)
    void insertInto(@Param("genreId") Long genre, @Param("productId") Long productId);
}
