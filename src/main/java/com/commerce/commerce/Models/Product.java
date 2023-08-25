package com.commerce.commerce.Models;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.annotation.Id;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private String category;
    private String subCategory;
    private ArrayList<String> images;
    private int price;
    private int quantity;
    private Date createdAt;
    private String updatedAt;
    
}
