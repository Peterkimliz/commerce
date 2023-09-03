package com.commerce.commerce.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.commerce.Dtos.SubcategoryDto;
import com.commerce.commerce.Exceptions.FoundException;
import com.commerce.commerce.Exceptions.NotFoundException;
import com.commerce.commerce.Models.Subcategory;
import com.commerce.commerce.Repository.SubcategoryRepository;

@Service
public class SubcategoryService {

    @Autowired
    private SubcategoryRepository subcategoryRepository;

    public SubcategoryDto createCategory(SubcategoryDto subcategoryDto, String categoryId) {
        Optional<Subcategory> foundCategory = subcategoryRepository.findByNameAndCategory(subcategoryDto.getName(),
                categoryId);
        if (foundCategory.isPresent()) {
            throw new FoundException("Subcategory already exists");
        }
        Subcategory subcategory = Subcategory.builder().createdAt(new Date(System.currentTimeMillis()))
                .updatedAt(new Date(System.currentTimeMillis())).name(subcategoryDto.getName()).category(categoryId)
                .build();
        subcategoryRepository.save(subcategory);

        SubcategoryDto subcategoryDto1Dto = SubcategoryDto.builder().category(categoryId).name(subcategoryDto.getName())
                .createdAt(new Date(System.currentTimeMillis()))
                .updatedAt(new Date(System.currentTimeMillis())).build();

        return subcategoryDto1Dto;
    }

    public List<SubcategoryDto> findSubcategoriesWithCategoryId(String categoryId) {
        List<Subcategory> foundCategories = subcategoryRepository.findByCategory(categoryId);

        return foundCategories.stream().map(e -> mapToSubcategoryDto(e)).toList();
    }

    private SubcategoryDto mapToSubcategoryDto(Subcategory subcategory) {
        return SubcategoryDto.builder().createdAt(subcategory.getCreatedAt()).updatedAt(subcategory.getUpdatedAt())
                .name(subcategory.getName()).category(subcategory.getCategory()).id(subcategory.getId()).build();
    }


    public SubcategoryDto updateSubCategory(String id, SubcategoryDto subcategoryDto) {

        Optional<Subcategory> subcat = subcategoryRepository.findById(id);
        if (!subcat.isPresent()) {
            throw new NotFoundException("Subcategory doesnot exists");
        }
        Subcategory subcategory = subcat.get();
        subcategory.setName(subcategory.getName()==null?subcategory.getName():subcategoryDto.getName());
        subcategory.setUpdatedAt(new Date(System.currentTimeMillis()));
        subcategoryRepository.save(subcategory);

        return SubcategoryDto.builder().name(subcategory.getName()).category(subcategory.getCategory())
                .id(subcategory.getId()).createdAt(subcategory.getCreatedAt()).updatedAt(subcategory.getUpdatedAt())
                .build();
    }

    public void deleteSubCategory(String id) {

        Optional<Subcategory> subcat = subcategoryRepository.findById(id);
        if (!subcat.isPresent()) {
            throw new NotFoundException("Subcategory doesnot exists");
        }

        subcategoryRepository.deleteById(id);
    }

}
