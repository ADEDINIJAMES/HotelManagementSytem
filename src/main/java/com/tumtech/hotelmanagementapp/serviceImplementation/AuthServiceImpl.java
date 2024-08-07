package com.tumtech.hotelmanagementapp.serviceImplementation;

import com.tumtech.hotelmanagementapp.dto.LoginRequest;
import com.tumtech.hotelmanagementapp.dto.RegisterRequest;
import com.tumtech.hotelmanagementapp.repository.UserRepository;
import com.tumtech.hotelmanagementapp.response.ApiResponse;
import com.tumtech.hotelmanagementapp.services.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AuthServiceImpl implements AuthService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByEmail(username);
    }

    public ApiResponse registerUser (RegisterRequest request){
        return new ApiResponse();
    }
    public ApiResponse registerAdmin (RegisterRequest request){
        return new ApiResponse();
    }
    public ApiResponse registerStaff (RegisterRequest request){
        return  new ApiResponse();
    }

    public ApiResponse LoginUser (LoginRequest loginRequest){
        return new ApiResponse();
    }

    public ApiResponse LoginStaff(LoginRequest loginRequest){
return new ApiResponse();
    }
}
