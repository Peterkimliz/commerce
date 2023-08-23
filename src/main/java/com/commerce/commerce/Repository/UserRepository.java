package com.commerce.commerce.Repository;

import java.util.Optional;

import com.commerce.commerce.Models.UserModel;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<UserModel,String>{
     Optional <UserModel> findByEmail(String emaail);
}
