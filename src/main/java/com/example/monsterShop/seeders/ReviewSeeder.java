package com.example.monsterShop.seeders;

import com.example.monsterShop.models.Product;
import com.example.monsterShop.models.Review;
import com.example.monsterShop.repositories.ProductRepository;
import com.example.monsterShop.repositories.ReviewRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ReviewSeeder implements CommandLineRunner {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public ReviewSeeder(ProductRepository productRepository, ReviewRepository reviewRepository) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }

    @Override
    public void run(String... args) {
        if (reviewRepository.count() == 0) {
            addReview("Fluffy Shock", "alice", 4.5, "Super cute and fluffy! My kids love it.");
            addReview("Fluffy Shock", "bob", 5.0, "Amazing surprise, would buy again.");
            addReview("Classic Screamer", "carol", 3.5, "A bit too scary for me, but great quality.");
            addReview("Angry Pompom", "dan", 4.0, "Funny and unique, perfect for my desk.");
            addReview("Geo Puff", "eve", 5.0, "So round and soft, I love it!");
            addReview("Blue Napper", "frank", 4.2, "Very relaxing to look at, nice color.");
            addReview("Happy Puff", "grace", 5.0, "Brings joy to everyone at home.");

            // Actualiza rating y reviewCount para cada producto
            List<Product> products = productRepository.findAll();
            for (Product product : products) {
                List<Review> reviews = reviewRepository.findByProductId(product.getId());
                int count = reviews.size();
                double avg = count > 0 ? reviews.stream().mapToDouble(Review::getRating).average().orElse(0.0) : 0.0;
                product.setReviewCount(count);
                product.setRating(avg);
                productRepository.save(product);
            }
        }
    }

    private void addReview(String productName, String username, double rating, String body) {
        Optional<Product> productOpt = productRepository.findAll().stream()
                .filter(p -> p.getName().equals(productName))
                .findFirst();
        productOpt.ifPresent(product -> {
            Review review = new Review(null, username, rating, body, product);
            reviewRepository.save(review);
        });
    }
}