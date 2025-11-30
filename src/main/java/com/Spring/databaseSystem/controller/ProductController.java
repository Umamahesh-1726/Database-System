package com.Spring.databaseSystem.controller;

import com.Spring.databaseSystem.dto.*;
import com.Spring.databaseSystem.service.ProductService;
import com.Spring.databaseSystem.util.ApiResponse;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/items")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody CreateProductRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.success("Created", service.create(req)));
    }

    @GetMapping
    public ResponseEntity<ApiResponse> list(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int limit,
            @RequestParam(required = false) String search,
            @RequestParam(required = false) String category
    ) {
        Pageable pageable = PageRequest.of(page, limit);
        return ResponseEntity.ok(ApiResponse.success("OK", service.list(search, category, pageable)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> get(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success("OK", service.getById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> update(@PathVariable Long id, @RequestBody UpdateProductRequest req) {
        return ResponseEntity.ok(ApiResponse.success("Updated", service.update(id, req)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Deleted", null));
    }
}
