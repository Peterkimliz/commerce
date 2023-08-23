package com.commerce.commerce.Dtos;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Register {
    @NotBlank(message = "please enter fullname")
    private String fullname;
    @NotBlank(message = "please enter email")
    private String email;
    @NotBlank(message = "please enter phone")
    private String phone;
    @NotBlank(message = "please enter password")
    private String password;
    @NotBlank(message = "please enter type")
    private String type;

}
