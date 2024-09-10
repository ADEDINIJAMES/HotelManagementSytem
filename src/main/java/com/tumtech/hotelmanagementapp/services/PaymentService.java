package com.tumtech.hotelmanagementapp.services;

import com.tumtech.hotelmanagementapp.response.ApiResponse;

import java.math.BigDecimal;

public interface PaymentService {
    BigDecimal validatePayment(String bookingRef);
    ApiResponse pay (String name, String channel, BigDecimal amount);

    Boolean pay ();
}
