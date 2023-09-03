package com.commerce.commerce.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReviewRequest {
    @NotBlank(message = "review message required ")
    private String message;
    @NotBlank(message = "review product required ")
    private String productId;
     @NotBlank(message = "review rating required ")
    private double rating;
     @NotBlank(message = "reviewer required ")
    private String reviewer;

    
}
