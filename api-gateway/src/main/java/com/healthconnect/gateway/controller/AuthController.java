package com.healthconnect.gateway.controller;

import com.healthconnect.gateway.dto.AuthRequest;
import com.healthconnect.gateway.dto.AuthResponse;
import com.healthconnect.gateway.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest request) {
        // Academic / Demo Authentication Validation
        if ("admin".equalsIgnoreCase(request.getUsername()) && "admin123".equals(request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername(), "ROLE_ADMIN");
            return ResponseEntity.ok(new AuthResponse(token, request.getUsername(), "ROLE_ADMIN"));
        } else if ("patient".equalsIgnoreCase(request.getUsername()) && "patient123".equals(request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername(), "ROLE_PATIENT");
            return ResponseEntity.ok(new AuthResponse(token, request.getUsername(), "ROLE_PATIENT"));
        } else if ("doctor".equalsIgnoreCase(request.getUsername()) && "doctor123".equals(request.getPassword())) {
            String token = jwtUtil.generateToken(request.getUsername(), "ROLE_DOCTOR");
            return ResponseEntity.ok(new AuthResponse(token, request.getUsername(), "ROLE_DOCTOR"));
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                .body("Invalid Username or Password! Demo Users:\n1. admin / admin123\n2. patient / patient123\n3. doctor / doctor123");
    }
}
