package com.commerce.commerce.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.commerce.commerce.Dtos.ReviewRequest;
import com.commerce.commerce.Dtos.ReviewRespose;
import com.commerce.commerce.Exceptions.FoundException;
import com.commerce.commerce.Models.Review;
import com.commerce.commerce.Models.UserModel;
import com.commerce.commerce.Repository.ReviewRepository;
import com.commerce.commerce.Repository.UserRepository;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository repository;
    @Autowired
    private UserRepository userRepository;

    public ReviewRespose createReview(ReviewRequest request) {
        Optional<Review> foundReview = repository.findByReviewerAndProductId(request.getReviewer(),
                request.getProductId());

        if (foundReview.isPresent()) {
            throw new FoundException("You have already reviewed this product");
        }
        Review review = Review.builder()
                .createdAt(new Date(System.currentTimeMillis()))
                .updatedAt(new Date(System.currentTimeMillis()))
                .message(request.getMessage())
                .rating(request.getRating())
                .productId(request.getProductId())
                .reviewer(request.getReviewer())
                .build();
        repository.save(review);

        UserModel userModel = userRepository.findById(review.getReviewer()).get();
        ReviewRespose respose = ReviewRespose.builder()
                .createdAt(review.getCreatedAt())
                .updatedAt(review.getUpdatedAt())
                .message(review.getMessage())
                .reviewer(userModel)
                .rating(review.getRating())
                .productId(review.getProductId())
                .build();
        return respose;
    }

    public List<ReviewRespose> getReviewsByProduct(String productId, int pagenumber) {
        PageRequest page = PageRequest.of(pagenumber, 15).withSort(Sort.Direction.DESC, "createdAt");
        Page<Review> allReviews = repository.findByProductId(productId, page);
        return null;
    }

}
