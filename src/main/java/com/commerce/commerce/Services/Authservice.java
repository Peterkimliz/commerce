package com.commerce.commerce.Services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.commerce.commerce.Exceptions.FoundException;
import com.commerce.commerce.Security.JwtService;
import com.commerce.commerce.Security.UserDetailsImple;

import com.commerce.commerce.Dtos.Authresponse;
import com.commerce.commerce.Dtos.Register;
import com.commerce.commerce.Models.UserModel;
import com.commerce.commerce.Repository.UserRepository;

@Service
public class Authservice {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtService jwtService;
    @Autowired
    private UserDetailsImple userDetailsImple;

    public Authresponse createUser(Register register) {

        Optional<UserModel> foundUser = userRepository.findByEmail(register.getEmail());
        if (foundUser.isPresent()) {
            throw new FoundException("User with email address already exists");
        }
        UserModel userModel = new UserModel();
        userModel.setCreatedAt(new Date(System.currentTimeMillis()));
        userModel.setUpdatedAt(new Date(System.currentTimeMillis()));
        userModel.setEmail(register.getEmail());
        userModel.setFullname(register.getFullname());
        userModel.setImage("");
        userModel.setPhone(register.getPhone());
        userModel.setPassword(passwordEncoder.encode(register.getPassword()));
        userRepository.save(userModel);

        UserDetails userDetails = userDetailsImple.loadUserByUsername(register.getEmail());

         System.out.println("usermodel is"+userDetails);


        String token = jwtService.generateToken(userDetails);
        Authresponse authresponse = new Authresponse();
        authresponse.setToken(token);
        authresponse.setUser(userModel);
        return authresponse;

    }

}
