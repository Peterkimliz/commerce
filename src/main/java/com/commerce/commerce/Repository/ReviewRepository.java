package com.commerce.commerce.Repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.commerce.commerce.Models.Review;


public interface ReviewRepository extends MongoRepository<Review,String> {


    Page<Review> findByProductId(String productId, PageRequest page);

    Optional<Review> findByReviewerAndProductId(String reviewer, String productId);
    
}
