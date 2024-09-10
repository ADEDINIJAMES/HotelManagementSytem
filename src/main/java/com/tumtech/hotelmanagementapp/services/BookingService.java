package com.tumtech.hotelmanagementapp.services;

import com.tumtech.hotelmanagementapp.dto.BookingDto;
import com.tumtech.hotelmanagementapp.dto.GuestDto;
import com.tumtech.hotelmanagementapp.entity.Booking;
import com.tumtech.hotelmanagementapp.response.ApiResponse;

public interface BookingService {
    ApiResponse bookRoom (BookingDto bookingDto);
    ApiResponse checkIn (String bookingRef);
    ApiResponse updateBooking (Long booking);
    ApiResponse checkOut (String bookingRef);
    ApiResponse cancelBooking (String bookingRef);
    ApiResponse deleteBooking (String bookingRef);
}
