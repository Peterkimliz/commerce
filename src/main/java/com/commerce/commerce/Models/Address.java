package com.commerce.commerce.Models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "address")
public class Address {
    @Id
    private String id;
    private String city;
    private String country;
    private String state;
    private String postalcode;
    @DocumentReference(lazy = true)
    private UserModel userId;
    private Date createdAt;
    private Date updatedAt;

}
