package com.commerce.commerce.Dtos;

import java.util.Date;

import jakarta.validation.constraints.NotBlank;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDto {
    private String id;
    @NotBlank(message = "Enter category name")
    private String name;
    private Date createAt;
    private Date updatedAt;
}
