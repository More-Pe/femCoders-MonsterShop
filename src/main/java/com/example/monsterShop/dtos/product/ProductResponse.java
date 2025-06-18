package com.example.monsterShop.dtos.product;

public record ProductResponse(
        Long id,
        String name,
        String description,
        double price,
        String imageUrl,
        double rating,
        int reviewCount,
        boolean featured
) {
}
