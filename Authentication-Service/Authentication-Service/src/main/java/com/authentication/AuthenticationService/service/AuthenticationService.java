package com.authentication.AuthenticationService.service;

import com.authentication.AuthenticationService.dto.SignUpDto;
import com.authentication.AuthenticationService.entity.UserCredential;
import com.authentication.AuthenticationService.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    @Autowired
    private UserCredentialRepository userCredentialRepository;

    @Autowired
    private JwtService jwtService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    public SignUpDto saveUser(UserCredential userCredential){
        userCredential.setPassword(passwordEncoder.encode(userCredential.getPassword()));
        userCredentialRepository.save(userCredential);
        return new SignUpDto("Admin Account successfully created","200",userCredential.getUserName());

    }

    // Generate Token Method call jwts service class generate token method
    public String generateToken(String userName){
        return jwtService.generateToken(userName);
    }


//    Validate Token
    public void validateToken(String token){
        jwtService.validateToken(token);
    }


}
