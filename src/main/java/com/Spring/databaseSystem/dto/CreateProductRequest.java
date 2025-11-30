package com.Spring.databaseSystem.dto;

import jakarta.validation.constraints.*;
import java.math.BigDecimal;

public class CreateProductRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    private String category;

    @NotNull(message = "Price is required")
    @DecimalMin("0.0")
    private BigDecimal price;

    @NotNull(message = "Stock is required")
    @Min(0)
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
