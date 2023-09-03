package com.commerce.commerce.Models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Document(collection = "category")
public class Review {
    @Id
    private String id;
    private String message;
    private String productId;
    private double rating;
    @DocumentReference(lazy = true)
    private UserModel reviewer;
    private Date createdAt;
    private Date updatedAt;

}
