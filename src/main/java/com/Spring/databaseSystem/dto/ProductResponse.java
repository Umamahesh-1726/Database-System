package com.Spring.databaseSystem.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ProductResponse {

    private Long id;
    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Integer stock;
    private LocalDateTime createdAt;

    public ProductResponse(Long id, String name, String description, String category,
                           BigDecimal price, Integer stock, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.createdAt = createdAt;
    }

    // GETTERS
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String getCategory() { return category; }
    public BigDecimal getPrice() { return price; }
    public Integer getStock() { return stock; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
