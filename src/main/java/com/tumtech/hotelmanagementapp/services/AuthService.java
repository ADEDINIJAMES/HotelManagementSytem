package com.tumtech.hotelmanagementapp.services;

import com.tumtech.hotelmanagementapp.dto.LoginRequest;
import com.tumtech.hotelmanagementapp.dto.RegisterRequest;
import com.tumtech.hotelmanagementapp.response.ApiResponse;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface AuthService extends UserDetailsService {
    ApiResponse loginUser (LoginRequest loginRequest);
    ApiResponse registerUser(RegisterRequest request);
    ApiResponse registerAdmin (RegisterRequest request);
    ApiResponse registerStaff(RegisterRequest request);
    ApiResponse LogoutUser (Long userId);
}
