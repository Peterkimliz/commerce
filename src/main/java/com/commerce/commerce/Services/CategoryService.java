package com.commerce.commerce.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.commerce.commerce.Dtos.CategoryDto;
import com.commerce.commerce.Exceptions.FoundException;
import com.commerce.commerce.Exceptions.NotFoundException;
import com.commerce.commerce.Models.Category;
import com.commerce.commerce.Repository.CategoryRepository;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryDto createCategory(CategoryDto categoryDto) {
        Optional<Category> foundCategory = categoryRepository.findByName(categoryDto.getName());
        if (foundCategory.isPresent()) {
            throw new FoundException("Ccategory already exists");
        }
        Category category =Category.builder().createAt(new Date(System.currentTimeMillis()))
                .updatedAt(new Date(System.currentTimeMillis())).name(categoryDto.getName())
                .build();
        categoryRepository.save(category);

    CategoryDto categoryDto1Dto =CategoryDto.builder().name(categoryDto.getName())
                .createAt(new Date(System.currentTimeMillis()))
                .id(category.getId())
                .updatedAt(new Date(System.currentTimeMillis())).build();

        return categoryDto1Dto;
    }

    public List<CategoryDto> findCategories() {
        List<Category> foundCategories = categoryRepository.findAll(Sort.by(Sort.Direction.DESC,"createAt"));

        return foundCategories.stream().map(e -> mapToSubcategoryDto(e)).toList();
    }

    private CategoryDto mapToSubcategoryDto(Category category) {
        return CategoryDto.builder().createAt(category.getCreateAt()).updatedAt(category.getUpdatedAt())
                .name(category.getName()).id(category.getId()).build();
    }

    public CategoryDto updateCategory(String id, CategoryDto subcategoryDto) {

        Optional<Category>cat = categoryRepository.findById(id);
        if (!cat.isPresent()) {
            throw new NotFoundException("Category doesnot exists");
        }
        Category category = cat.get();
        category.setName(category.getName() == null ? category.getName() : subcategoryDto.getName());
        category.setUpdatedAt(new Date(System.currentTimeMillis()));
        categoryRepository.save(category);

        return CategoryDto.builder().name(category.getName()) .id(category.getId()).createAt(category.getCreateAt()).updatedAt(category.getUpdatedAt())
                .build();
    }

    public void deleteCategory(String id) {

        Optional<Category> subcat = categoryRepository.findById(id);
        if (!subcat.isPresent()) {
            throw new NotFoundException("Subcategory doesnot exists");
        }

        categoryRepository.deleteById(id);
    }

}
