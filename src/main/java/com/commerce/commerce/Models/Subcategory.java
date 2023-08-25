package com.commerce.commerce.Models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Document(collection="subcategory")
public class Subcategory {
     @Id
    private String id;
    private String name;
    private String categoryId;
    private Date createdAt;
    private Date updatedAt;
}
