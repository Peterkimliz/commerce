package com.commerce.commerce.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.commerce.commerce.Models.Category;

public interface CategoryRepository extends MongoRepository<Category,String> {
     Optional<Category> findByName(String name);
    
}
