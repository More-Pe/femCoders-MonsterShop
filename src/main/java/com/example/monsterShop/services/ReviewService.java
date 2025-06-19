package com.example.monsterShop.services;

import com.example.monsterShop.dtos.review.ReviewMapper;
import com.example.monsterShop.dtos.review.ReviewRequest;
import com.example.monsterShop.dtos.review.ReviewResponse;
import com.example.monsterShop.models.Product;
import com.example.monsterShop.models.Review;
import com.example.monsterShop.repositories.ProductRepository;
import com.example.monsterShop.repositories.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;

    public ReviewService(ReviewRepository reviewRepository, ProductRepository productRepository){
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }

   public ReviewResponse addReview(ReviewRequest reviewRequest){
        Product foundProduct = productRepository.findById(reviewRequest.productId())
                .orElseThrow(() -> new IllegalArgumentException("Product not found"));
        Review newReview = ReviewMapper.dtoToEntity(reviewRequest, foundProduct);
        Review savedReview = reviewRepository.save(newReview);
        return ReviewMapper.entityToDto(savedReview);
    }

    public List<ReviewResponse> getReviewsByProductId(Long productId) {
        List<Review> reviews = reviewRepository.findByProductId(productId);
        return reviews.stream().map(review -> ReviewMapper.entityToDto(review)).collect(Collectors.toList());

}}
