package com.authentication.AuthenticationService.controller;

import com.authentication.AuthenticationService.dto.AuthRequest;
import com.authentication.AuthenticationService.dto.ErrorResponse;
import com.authentication.AuthenticationService.dto.LoginDTO;
import com.authentication.AuthenticationService.dto.SignUpDto;
import com.authentication.AuthenticationService.entity.UserCredential;
import com.authentication.AuthenticationService.service.AuthenticationService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
public class AuthController {


    @Autowired
    private AuthenticationService authenticationService;
    @Autowired
    private AuthenticationManager authenticationManager; // Bean is created in Config Class

    @PostMapping("/signup")
    public SignUpDto addNewUser(@RequestBody  UserCredential userCredential){
        return authenticationService.saveUser(userCredential);
    }

//    @PostMapping("/token")
    @PostMapping("/login")
    public ResponseEntity<LoginDTO> getToken(@RequestBody AuthRequest authRequest){
//        Authentication Manager needs to communicate with DB using UserDetailService
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword()));
        if(authenticate.isAuthenticated()){
        String token = authenticationService.generateToken(authRequest.getUserName());
        return ResponseEntity.ok(new LoginDTO("Login successful", HttpStatus.OK.toString(), authRequest.getUserName(), token));
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new LoginDTO("Incorrect username/password provided. Please retry", "401"));
        }
    }

    @GetMapping("/validate")
    public String validateToken(@RequestParam("token") String token){
        authenticationService.validateToken(token);
        return "Token is valid";
    }


}
