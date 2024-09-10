package com.tumtech.hotelmanagementapp.serviceImplementation;

import com.tumtech.hotelmanagementapp.repository.UserRepository;
import com.tumtech.hotelmanagementapp.response.ApiResponse;
import com.tumtech.hotelmanagementapp.services.UserServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserServices {
    private UserRepository userRepository;
    @Override
    public ApiResponse getUser(Long id) {
        return null;
    }

    @Override
    public ApiResponse getAllStaff() {
        return null;
    }

    @Override
    public ApiResponse removeUser(String username) {
        return null;
    }
}
