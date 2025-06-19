package com.example.monsterShop.dtos.product;

import com.example.monsterShop.dtos.review.ReviewMapper;
import com.example.monsterShop.dtos.review.ReviewResponse;
import com.example.monsterShop.models.Product;

import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {
    public static Product dtoToEntity (ProductRequest dto){
        return new Product (dto.name(), dto.description(), dto.price(), dto.imageUrl(), dto.featured());
    }

    public static ProductResponse entityToDto (Product product){
        Long id = product.getId();
        String name = product.getName();
        String description = product.getDescription();
        double price = product.getPrice();
        String imageUrl = product.getImageUrl();
        double rating = product.getRating();
        int reviewCount = product.getReviewCount();
        boolean featured = product.isFeatured();

        List<ReviewResponse> reviews = product.getReviews() != null
                ? product.getReviews().stream().map(ReviewMapper::entityToDto).collect(Collectors.toList())
                : List.of();

        return new ProductResponse(id, name, description, price, imageUrl, rating, reviewCount, featured, reviews);
    }
}
