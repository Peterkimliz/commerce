package com.commerce.commerce.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.commerce.Dtos.CategoryDto;
import com.commerce.commerce.Services.CategoryService;

@RestController
@RequestMapping("/category")

public class CategoryController {
       @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody @Validated CategoryDto categoryDto) {
        return new ResponseEntity<CategoryDto>(categoryService.createCategory(categoryDto),
                HttpStatus.CREATED);

    }
    @PutMapping("/create/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto subcategoryDto,@PathVariable("id") String id) {
        return new ResponseEntity<CategoryDto>(categoryService.updateCategory(id,subcategoryDto),
                HttpStatus.OK);

    }

    @GetMapping("/all")
    public ResponseEntity<List<CategoryDto>> getSubCategories(@PathVariable("categoryId") String categoryId) {
        return new ResponseEntity<List<CategoryDto>>(categoryService.findCategories(),HttpStatus.OK);

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") String id) {
        categoryService.deleteCategory(id);
        return new ResponseEntity<String>("Category deleted successfully",HttpStatus.OK);

    }
    
}
