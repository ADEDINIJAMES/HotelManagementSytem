package com.tumtech.hotelmanagementapp.repository;

import com.tumtech.hotelmanagementapp.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
