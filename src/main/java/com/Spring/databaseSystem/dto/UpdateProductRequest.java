package com.Spring.databaseSystem.dto;

import java.math.BigDecimal;

public class UpdateProductRequest {

    private String name;
    private String description;
    private String category;
    private BigDecimal price;
    private Integer stock;

    // GETTERS & SETTERS
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }
}
