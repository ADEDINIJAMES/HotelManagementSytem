package com.tumtech.hotelmanagementapp.controller;

import com.tumtech.hotelmanagementapp.dto.LoginRequest;
import com.tumtech.hotelmanagementapp.response.ApiResponse;
import com.tumtech.hotelmanagementapp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private AuthService authService ;
    @PostMapping("/user")
    public ResponseEntity<ApiResponse> loginUser (@RequestBody LoginRequest loginRequest){
        try {
            return ResponseEntity.ok().body(authService.loginUser(loginRequest));
        }catch (Exception e){
            return ResponseEntity.status(Integer.parseInt(authService.loginUser(loginRequest).getStatusCode())).body(authService.loginUser(loginRequest));
        }
    }

    
}
