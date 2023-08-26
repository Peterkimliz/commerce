package com.commerce.commerce.Dtos;

import java.util.Date;

import com.commerce.commerce.Models.UserModel;

import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReviewRespose {
  private String id;
    private String message;
    private String productId;
    private double rating;
    private UserModel reviewer;
    private Date createdAt;
    private Date updatedAt;
}
