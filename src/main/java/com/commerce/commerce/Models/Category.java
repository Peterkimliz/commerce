package com.commerce.commerce.Models;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection="category")
public class Category {
    private String id;
    private String name;
    private Date createAt;
    private Date updatedAt;
    
}
