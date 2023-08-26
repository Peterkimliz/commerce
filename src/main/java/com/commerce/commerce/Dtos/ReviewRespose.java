package com.commerce.commerce.Dtos;

import java.util.Date;
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
    private String reviewer;
    private Date createdAt;
    private Date updatedAt;
}
