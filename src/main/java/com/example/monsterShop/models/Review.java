package com.example.monsterShop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(nullable = false, unique = true)
   private String username;

   @Column(nullable = false)
   double rating;

   @Column(nullable = false)
   String body;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "product_id")
   private Product product;


}
