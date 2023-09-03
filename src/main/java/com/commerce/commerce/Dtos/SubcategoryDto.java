package com.commerce.commerce.Dtos;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubcategoryDto {
    private String id;
    @NotBlank(message = "please provide the name")
    private String name;
    private String category;
    private Date createdAt;
    private Date updatedAt;
}
