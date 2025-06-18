package com.example.monsterShop.dtos.review;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ReviewResponse(
    Long id,
    String username,
    Double rating,
    String body,
    Long productId) {
    }
