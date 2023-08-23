package com.commerce.commerce.Dtos;

import com.commerce.commerce.Models.UserModel;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authresponse {
    private UserModel user;
    private String token;

}
