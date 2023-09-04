package com.commerce.commerce.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.commerce.commerce.Dtos.AddressDto;
import com.commerce.commerce.Dtos.AddressRequest;
import com.commerce.commerce.Exceptions.FoundException;
import com.commerce.commerce.Models.Address;
import com.commerce.commerce.Models.UserModel;
import com.commerce.commerce.Repository.AddressRepository;
import com.commerce.commerce.Repository.UserRepository;



@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;
    @Autowired 
    private UserRepository userRepository;

    public AddressRequest createAddress(AddressDto addressDto, String userId) {
       
        Optional<UserModel> userFound = userRepository.findById(userId);
       Optional<Address> foundAddress = addressRepository.findByUserId(userFound.get());
        if (foundAddress.isPresent()) {
            throw new FoundException("You already have an address");
        }
        if(!userFound.isPresent()){
             throw new FoundException("User with id not found");
        }
        Address address = Address.builder().createdAt(new Date(System.currentTimeMillis()))
                .updatedAt(new Date(System.currentTimeMillis())).city(addressDto.getCity())
                .country(addressDto.getCountry()).state(addressDto.getState()).postalcode(addressDto.getPostalcode())
                .userId(userFound.get())
                .build();

        addressRepository.save(address);
        AddressRequest addressRequest = mapToAddressRequest(address);
        return addressRequest;

    }

    private AddressRequest mapToAddressRequest(Address address) {
        new AddressRequest();
        return AddressRequest.builder().city(address.getCity()).country(address.getCountry()).id(address.getId())
                .state(address.getState()).postalcode(address.getPostalcode()).user(address.getUserId()).build();
    }

    public AddressRequest getAddressByuserId(String userId) {
          Optional<UserModel> userFound = userRepository.findById(userId);
          Optional<Address> foundAddress = addressRepository.findByUserId(userFound.get());

        if (!foundAddress.isPresent()) {
            throw new FoundException("Address not found");
        }
        AddressRequest addressRequest = mapToAddressRequest(foundAddress.get());
        return addressRequest;

    }
    public List<Address> getAllAddressesd() {
       List<Address> foundAddress = addressRepository.findAll();
        if (foundAddress.size()==0) {
          return new ArrayList<>();
        }
       
        return foundAddress;

    }

    public AddressRequest updateAddressById(String id) {
        Optional<Address> foundAddress = addressRepository.findById(id);
        if (foundAddress.isPresent()) {
            throw new FoundException("Address not found");
        }
        Address address = foundAddress.get();
        address.setUpdatedAt(new Date(System.currentTimeMillis()));

        addressRepository.save(address);
        AddressRequest addressRequest = mapToAddressRequest(address);
        return addressRequest;

    }

    public void deleteAddressByuserId(String id) {
        Optional<Address> foundAddress = addressRepository.findById(id);
        if (foundAddress.isPresent()) {
            throw new FoundException("Address not found");
        }

      addressRepository.deleteById(id);

    }

}
