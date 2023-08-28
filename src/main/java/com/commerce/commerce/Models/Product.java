package com.commerce.commerce.Models;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "product")
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    @DocumentReference(lazy = true)
    private Category category;
    // @DocumentReference(lazy = true)
    // private Subcategory subCategory;
    private ArrayList<String> images;
    private int price;
    private int quantity;
    private Date createdAt;
    private String updatedAt;
    @DocumentReference(lazy = true)
    private UserModel user;

}
