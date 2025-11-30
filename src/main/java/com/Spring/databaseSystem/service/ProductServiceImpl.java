package com.Spring.databaseSystem.service;

import com.Spring.databaseSystem.dto.*;
import com.Spring.databaseSystem.exception.ResourceNotFoundException;
import com.Spring.databaseSystem.model.Product;
import com.Spring.databaseSystem.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public ProductResponse create(CreateProductRequest req) {
        Product p = new Product(
                req.getName(),
                req.getDescription(),
                req.getCategory(),
                req.getPrice(),
                req.getStock()
        );

        return toResponse(repo.save(p));
    }

    @Override
    public Page<ProductResponse> list(String search, String category, Pageable pageable) {
        Page<Product> page = repo.findByDeletedFalseAndNameContainingIgnoreCaseAndCategoryContainingIgnoreCase(
                search == null ? "" : search,
                category == null ? "" : category,
                pageable
        );

        return page.map(this::toResponse);
    }

    @Override
    public ProductResponse getById(Long id) {
        Product p = repo.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        return toResponse(p);
    }

    @Override
    public ProductResponse update(Long id, UpdateProductRequest req) {
        Product p = repo.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        if (req.getName() != null) p.setName(req.getName());
        if (req.getDescription() != null) p.setDescription(req.getDescription());
        if (req.getCategory() != null) p.setCategory(req.getCategory());
        if (req.getPrice() != null) p.setPrice(req.getPrice());
        if (req.getStock() != null) p.setStock(req.getStock());

        return toResponse(repo.save(p));
    }

    @Override
    public void delete(Long id) {
        Product p = repo.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        p.setDeleted(true);
        repo.save(p);
    }

    private ProductResponse toResponse(Product p) {
        return new ProductResponse(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getCategory(),
                p.getPrice(),
                p.getStock(),
                p.getCreatedAt()
        );
    }
}
