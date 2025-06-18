package com.example.monsterShop.dtos.review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ReviewRequest(
    Long id,
    @NotBlank(message = "Username is required")
    String username,
    @Size(min = 2, max = 50, message = "Username must contain min 2 and max 50 characters")
    @NotBlank(message = "Rating is required")
    Double rating,
    @NotBlank(message = "Review is required")
    @Size(min = 10, max = 200, message = "Review must contain min 10 and max 200 characters")
    String body,
    Long productId) {
    }
