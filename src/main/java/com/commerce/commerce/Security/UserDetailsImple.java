package com.commerce.commerce.Security;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.commerce.commerce.Models.UserModel;
import com.commerce.commerce.Repository.UserRepository;


@Component

public class UserDetailsImple implements UserDetailsService {
    @Autowired
    private  UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserModel> user=userRepository.findByEmail(username);
        if(user.isPresent()){
            return new User(user.get().getEmail(), user.get().getPassword(),new ArrayList<>());

        }else{
            throw new UsernameNotFoundException("User not found");
        }
   
    }
    
}
