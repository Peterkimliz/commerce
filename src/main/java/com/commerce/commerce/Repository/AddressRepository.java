package com.commerce.commerce.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.commerce.commerce.Models.Address;

public interface AddressRepository extends MongoRepository<Address, String> {
    Optional<Address> findByUserId(String userId);
}
