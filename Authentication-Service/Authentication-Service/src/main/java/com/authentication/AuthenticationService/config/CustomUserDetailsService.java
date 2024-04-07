package com.authentication.AuthenticationService.config;

import com.authentication.AuthenticationService.entity.UserCredential;
import com.authentication.AuthenticationService.repository.UserCredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserCredentialRepository userCredentialRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserCredential> optionalUserCredentials =userCredentialRepository.findByUserName(username);
        return  optionalUserCredentials.map(CustomUserDetail::new).orElseThrow(()->new UsernameNotFoundException("user not found"+username));


    }
}
