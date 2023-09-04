package com.commerce.commerce.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.commerce.Dtos.AddressDto;
import com.commerce.commerce.Dtos.AddressRequest;
import com.commerce.commerce.Models.Address;
import com.commerce.commerce.Services.AddressService;
import java.util.List;
@RestController
@RequestMapping("/api/address")
public class AddressController {

@Autowired
private AddressService addressService;

@PostMapping("/create/{userId}")
 public ResponseEntity<AddressRequest> createAddress(@RequestBody @Validated AddressDto addressDto,@PathVariable("userId") String userId){
    return new ResponseEntity<AddressRequest>(addressService.createAddress(addressDto, userId), HttpStatus.CREATED);

 }   
@GetMapping("/all")
 public ResponseEntity<List<Address>> getAddresses(){
    return new ResponseEntity<List<Address>>(addressService.getAllAddressesd(), HttpStatus.OK);

 }   
@GetMapping("/{userId}")
 public ResponseEntity<AddressRequest> getAddressByUserId(@PathVariable("userId") String userId){
    return new ResponseEntity<AddressRequest>(addressService.getAddressByuserId(userId), HttpStatus.OK);

 }   
    
}
