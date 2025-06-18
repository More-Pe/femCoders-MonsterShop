package com.example.monsterShop.dtos.review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ReviewRequest(
    Long id,
    @NotBlank(message = "Username is required")
    @Size(min = 2, max = 50, message = "Username must contain min 2 and max 50 characters")
    String username,
    @NotNull(message = "Rating is required")
    @Positive(message = "Rating must be positive")
    Double rating,
    @NotBlank(message = "Review is required")
    @Size(min = 10, max = 200, message = "Review must contain min 10 and max 200 characters")
    String body,
    Long productId) {
    }
