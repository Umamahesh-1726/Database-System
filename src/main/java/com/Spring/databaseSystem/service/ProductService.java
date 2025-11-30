package com.Spring.databaseSystem.service;

import com.Spring.databaseSystem.dto.*;
import org.springframework.data.domain.*;

public interface ProductService {

    ProductResponse create(CreateProductRequest req);

    Page<ProductResponse> list(String search, String category, Pageable pageable);

    ProductResponse getById(Long id);

    ProductResponse update(Long id, UpdateProductRequest req);

    void delete(Long id);
}
