// repository/AuthorRepository.java
package com.example.lab3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BrandRepository extends JpaRepository<com.example.lab3.model.Brand, Long> {

    /* -------- optional custom queries -------- */

    // Example: SELECT * FROM author WHERE name LIKE %?1%
    List<com.example.lab3.model.Brand> findByNameContainingIgnoreCase(String fragment);

    // Example: count books per author via JPQL
    @Query("select count(b) from Author a join a.books b where a.id = :id")
    long countBooksByAuthorId(@Param("id") Long id);
}
