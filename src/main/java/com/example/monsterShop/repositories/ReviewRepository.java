package com.example.monsterShop.repositories;

import com.example.monsterShop.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
