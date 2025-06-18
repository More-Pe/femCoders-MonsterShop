package com.example.monsterShop.dtos.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @NotBlank(message = "Product name is required")
        @Size(min = 2, max = 50, message = "Product name must contain min 2 and max 50 characters")
        String name,
        @NotBlank(message = "Product description is required")
        @Size(min = 10, max = 200, message = "Name must contain min 10 and max 200 characters")
        String description,
        @NotNull(message = "Price is required")
        @Positive(message = "Price must be positive")
        Double price,
        @NotBlank(message = "Product image is required")
        String imageUrl,
        boolean featured
) {
}
