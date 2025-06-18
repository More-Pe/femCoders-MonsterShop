package com.example.monsterShop.controllers;

import com.example.monsterShop.dtos.review.ReviewRequest;
import com.example.monsterShop.dtos.review.ReviewResponse;
import com.example.monsterShop.services.ReviewService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping("/reviews")
    public ResponseEntity<ReviewResponse> addReview(@Valid @RequestBody ReviewRequest reviewRequest) {
    return new ResponseEntity<>(reviewService.addReview(reviewRequest), HttpStatus.CREATED);
    }

    @GetMapping("/reviews/{productId}")
    public ResponseEntity<List<ReviewResponse>> getReviewsByProductId(@PathVariable Long productId) {
        List<ReviewResponse> reviews = reviewService.getReviewsByProductId(productId);
        if (reviews.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(reviews, HttpStatus.OK);
    }
}
