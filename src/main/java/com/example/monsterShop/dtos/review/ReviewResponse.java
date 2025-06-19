package com.example.monsterShop.dtos.review;

public record ReviewResponse(
    Long id,
    String username,
    Double rating,
    String body,
    Long productId) {
    }
