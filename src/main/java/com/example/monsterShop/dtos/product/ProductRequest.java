package com.example.monsterShop.dtos.product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ProductRequest(
        @NotBlank(message = "Product name is required")
        @Size(min = 2, max = 50, message = "Product name must contain min 2 and max 50 characters")
        String name,
        @NotBlank(message = "Product description is required")
        @Size(min = 10, max = 200, message = "Name must contain min 10 and max 200 characters")
        String description,
        @NotBlank(message = "Price is required")
        Double price,
        @NotBlank(message = "Product image is required")
        String imageUrl,
        boolean featured
) {
}
