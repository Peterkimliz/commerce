package com.commerce.commerce.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.commerce.commerce.Models.Product;
public interface ProductRepository extends MongoRepository<Product,String> {
    
}
