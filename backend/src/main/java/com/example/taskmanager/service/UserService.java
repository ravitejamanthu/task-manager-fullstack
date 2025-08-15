package com.example.taskmanager.service;

import com.example.taskmanager.dto.LoginRequest;
import com.example.taskmanager.dto.RegisterRequest;
import com.example.taskmanager.model.User;
import com.example.taskmanager.repository.UserRepository;
import com.example.taskmanager.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private JwtUtils jwtUtils;
    
    public Map<String, Object> registerUser(RegisterRequest registerRequest) {
        Map<String, Object> response = new HashMap<>();
        
        // Check if username already exists
        if (userRepository.existsByUsername(registerRequest.getUsername())) {
            response.put("success", false);
            response.put("message", "Username is already taken!");
            return response;
        }
        
        // Check if email already exists
        if (userRepository.existsByEmail(registerRequest.getEmail())) {
            response.put("success", false);
            response.put("message", "Email is already in use!");
            return response;
        }
        
        // Create new user
        User user = new User();
        user.setUsername(registerRequest.getUsername());
        user.setEmail(registerRequest.getEmail());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        
        userRepository.save(user);
        
        response.put("success", true);
        response.put("message", "User registered successfully!");
        return response;
    }
    
    public Map<String, Object> authenticateUser(LoginRequest loginRequest) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
            
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String jwt = jwtUtils.generateToken(userDetails);
            
            response.put("success", true);
            response.put("token", jwt);
            response.put("username", userDetails.getUsername());
            response.put("message", "Login successful!");
            
        } catch (Exception e) {
            response.put("success", false);
            response.put("message", "Invalid username or password!");
        }
        
        return response;
    }
}
