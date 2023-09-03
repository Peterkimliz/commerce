package com.commerce.commerce.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.commerce.Dtos.SubcategoryDto;
import com.commerce.commerce.Services.SubcategoryService;

@RestController
@RequestMapping("/subcategory")

public class SubcategoryController {

    @Autowired
    SubcategoryService subcategoryService;

    @PostMapping("/create/{categoryId}")
    public ResponseEntity<SubcategoryDto> createCategory(@RequestBody @Validated SubcategoryDto subcategoryDto,
            @PathVariable("categoryId") String categoryId) {
        return new ResponseEntity<SubcategoryDto>(subcategoryService.createCategory(subcategoryDto, categoryId),
                HttpStatus.CREATED);

    }
    @PostMapping("/create/{id}")
    public ResponseEntity<SubcategoryDto> updateSubCategory(@RequestBody SubcategoryDto subcategoryDto,@PathVariable("id") String id) {
        return new ResponseEntity<SubcategoryDto>(subcategoryService.updateSubCategory(id,subcategoryDto),
                HttpStatus.OK);

    }
    @PostMapping("/all/{categoryId}")
    public ResponseEntity<List<SubcategoryDto>> getSubCategories(@PathVariable("categoryId") String categoryId) {
        return new ResponseEntity<List<SubcategoryDto>>(subcategoryService.findSubcategoriesWithCategoryId(categoryId),HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") String id) {
        subcategoryService.deleteSubCategory(id);
        return new ResponseEntity<String>("Subcategory deleted successfully",HttpStatus.OK);

    }

}
