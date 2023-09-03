package com.commerce.commerce.Models;
import java.util.Date;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document("users")
public class UserModel{
    @Id
    private String id;
    private String fullname;
    private String email;
    private String phone;
    @JsonIgnore
    private String password;
    private String image = "";
    private String type;
    private boolean accountVerified = false;
    private Date createdAt;
    private Date updatedAt;

   
}
