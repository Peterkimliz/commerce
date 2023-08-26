package com.commerce.commerce.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.commerce.Dtos.ReviewRequest;
import com.commerce.commerce.Dtos.ReviewRespose;
import com.commerce.commerce.Services.ReviewService;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;
    
    @PostMapping("/product")
    public ResponseEntity<ReviewRespose>createReview(@RequestBody ReviewRequest request){
        return new ResponseEntity<ReviewRespose>(reviewService.createReview(request), HttpStatus.CREATED);
    }
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ReviewRespose>>getProductReviews(@PathVariable String productId, @RequestParam(required = true) int pageumber){
        return new ResponseEntity<List<ReviewRespose>>(reviewService.getReviewsByProduct(productId, pageumber), HttpStatus.OK);
    }



}
