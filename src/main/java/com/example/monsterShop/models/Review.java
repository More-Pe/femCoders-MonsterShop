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

   public Review(){

   }

   public Review(Long id, String username, Double rating, String body, Product product){
      this.id = id;
      this.username = username;
      this.rating = rating;
      this.body = body;
      this.product = product;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public double getRating() {
      return rating;
   }

   public void setRating(double rating) {
      this.rating = rating;
   }

   public String getBody() {
      return body;
   }

   public void setBody(String body) {
      this.body = body;
   }

   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }
}
