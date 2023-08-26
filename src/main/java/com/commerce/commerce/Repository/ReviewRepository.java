package com.commerce.commerce.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.commerce.commerce.Models.Review;


public interface ReviewRepository extends MongoRepository<Review,String> {
    
    Optional<Review> findByReviewerAndProductId(String reviewer,String productid);
    
}
