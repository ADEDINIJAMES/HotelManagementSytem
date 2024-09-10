package com.tumtech.hotelmanagementapp.services;

import com.tumtech.hotelmanagementapp.response.ApiResponse;

public interface UserServices {
    ApiResponse getUser (Long id);
    ApiResponse getAllStaff ();
    ApiResponse removeUser (String username);

}
