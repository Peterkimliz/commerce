package com.commerce.commerce.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.commerce.commerce.Dtos.Authresponse;
import com.commerce.commerce.Dtos.Register;
import com.commerce.commerce.Services.Authservice;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/auth")
@RequiredArgsConstructor
public class AuthController {

private final Authservice authservice;

 @PostMapping("/signup")
 public ResponseEntity<Authresponse> createUser(@RequestBody  @Validated  Register register){
    return new ResponseEntity<Authresponse>(authservice.createUser(register), HttpStatus.CREATED);
 }   
    
}
