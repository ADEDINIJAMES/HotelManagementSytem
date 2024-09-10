package com.tumtech.hotelmanagementapp.serviceImplementation;

import com.tumtech.hotelmanagementapp.repository.BookingRepository;
import com.tumtech.hotelmanagementapp.repository.PaymentRepository;
import com.tumtech.hotelmanagementapp.repository.UserRepository;
import com.tumtech.hotelmanagementapp.response.ApiResponse;
import com.tumtech.hotelmanagementapp.services.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private BookingRepository bookingRepository;
    private UserRepository userRepository;
    private PaymentRepository paymentRepository;
    @Override
    public BigDecimal validatePayment(String bookingRef) {
        return null;
    }

    @Override
    public ApiResponse pay(String name, String channel, BigDecimal amount) {
        return null;
    }

    @Override
    public Boolean pay() {
        return null;
    }
}
