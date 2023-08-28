package com.commerce.commerce.Dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {
    @NotBlank(message = "City required ")
    private String city;
    @NotBlank(message = "country required ")
    private String country;
    @NotBlank(message = "state required ")
    private String state;
    @NotBlank(message = "postalcode required ")
    private String postalcode;
}
