package com.example.monsterShop.dtos.product;

import com.example.monsterShop.models.Review;

import java.util.List;

public record ProductResponse(
        Long id,
        String name,
        String description,
        double price,
        String imageUrl,
        double rating,
        int reviewCount,
        boolean featured
        //,List<Review> reviews
) {
}
