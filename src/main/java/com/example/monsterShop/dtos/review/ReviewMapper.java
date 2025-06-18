package com.example.monsterShop.dtos.review;

import com.example.monsterShop.models.Product;
import com.example.monsterShop.models.Review;

public class ReviewMapper {
public static Review dtoToEntity (ReviewRequest dto, Product product){
    return new Review(dto.id(), dto.username(), dto.rating(), dto.body(),product);
}

public static ReviewResponse entityToDto (Review review){
    Long product = review.getProduct().getId();
    return new ReviewResponse(review.getId(), review.getUsername(), review.getRating(), review.getBody(), product);
}
}
