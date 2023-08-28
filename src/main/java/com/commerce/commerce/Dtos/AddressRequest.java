package com.commerce.commerce.Dtos;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressRequest {

    private String id;
    private String city;
    private String country;
    private String state;
    private String postalcode;

}
