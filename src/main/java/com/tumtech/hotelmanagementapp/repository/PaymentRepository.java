package com.tumtech.hotelmanagementapp.repository;

import com.tumtech.hotelmanagementapp.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository  extends JpaRepository<Payment, Long> {
}
