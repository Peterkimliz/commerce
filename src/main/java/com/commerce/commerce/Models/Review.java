package com.commerce.commerce.Models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "category")
public class Review {
    @Id
    private String id;
    private String message;
    private String productId;
    private double rating;
    private String reviewer;
    private Date createdAt;
    private Date updatedAt;

}
