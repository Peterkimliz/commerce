package com.commerce.commerce.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.commerce.commerce.Models.Subcategory;

public interface SubcategoryRepository  extends MongoRepository<Subcategory,String>{

    Optional<Subcategory> findByNameAndCategory(String name, String category);

    List<Subcategory> findByCategory(String categoryId);
    
}
