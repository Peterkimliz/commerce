package com.commerce.commerce.Repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.commerce.commerce.Models.Product;

public interface ProductRepository extends MongoRepository<Product,String> {      
    List<Product> findByCategory(String name);
    // List<Product> findByCategoryAndSubcategory(String name,String subcategory);

    
}
