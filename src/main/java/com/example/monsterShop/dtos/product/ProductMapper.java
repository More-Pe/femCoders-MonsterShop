package com.example.monsterShop.dtos.product;

import com.example.monsterShop.models.Product;

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

        return new ProductResponse(id, name, description, price, imageUrl, rating, reviewCount, featured
        );
    }
}
