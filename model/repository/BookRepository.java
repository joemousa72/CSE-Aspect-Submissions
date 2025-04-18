// repository/BookRepository.java
package com.example.lab3.repository;

import com.example.lab3.model.Cloth;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;



public interface BookRepository extends JpaRepository<Cloth, Long> {

    /* Example convenience finder */
    List<Cloth> findByAuthorId(Long authorId);

    /* Spring automatically implements:
          - findAll()
          - findById()
          - save()
          - deleteById()
       …and many more from JpaRepository                 */
}
