package com.digitalchief.model.repository;

import com.digitalchief.model.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Author findByName(String name);
    @Modifying
    @Transactional
    @Query(value = "insert into digital_chief.author_product values(:authorId, :productId)", nativeQuery = true)
    void insertInto(@Param("authorId") Long authorId, @Param("productId") Long productId);

}
