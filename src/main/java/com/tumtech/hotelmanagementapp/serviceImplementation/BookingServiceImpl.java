package com.tumtech.hotelmanagementapp.serviceImplementation;

import com.tumtech.hotelmanagementapp.dto.BookingDto;
import com.tumtech.hotelmanagementapp.repository.BookingRepository;
import com.tumtech.hotelmanagementapp.repository.UserRepository;
import com.tumtech.hotelmanagementapp.response.ApiResponse;
import com.tumtech.hotelmanagementapp.services.BookingService;
import com.tumtech.hotelmanagementapp.services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class BookingServiceImpl
        implements BookingService
{
    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private PaymentService paymentService;
    @Override
    public ApiResponse bookRoom(BookingDto bookingDto) {
        return null;
    }

    @Override
    public ApiResponse checkIn(String bookingRef) {
        return null;
    }

    @Override
    public ApiResponse updateBooking(Long booking) {
        return null;
    }

    @Override
    public ApiResponse checkOut(String bookingRef) {
        return null;
    }

    @Override
    public ApiResponse cancelBooking(String bookingRef) {
        return null;
    }

    @Override
    public ApiResponse deleteBooking(String bookingRef) {
        return null;
    }
}
