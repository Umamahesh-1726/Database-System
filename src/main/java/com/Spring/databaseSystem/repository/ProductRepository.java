package com.Spring.databaseSystem.repository;

import com.Spring.databaseSystem.model.Product;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByDeletedFalse(Pageable pageable);

    Optional<Product> findByIdAndDeletedFalse(Long id);

    Page<Product> findByDeletedFalseAndNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(
            String name,
            String category,
            Pageable pageable
    );
}
