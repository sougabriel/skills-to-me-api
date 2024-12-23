package com.sougabriel.skillstome.security;

import com.sougabriel.skillstome.user.model.UserModel;
import com.sougabriel.skillstome.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = this.userRepository.findByEmail(username).orElseThrow(() -> new UsernameNotFoundException("user not found!"));
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword_hash(), new ArrayList<>());
    }
}
