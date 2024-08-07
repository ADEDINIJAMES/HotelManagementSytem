package com.tumtech.hotelmanagementapp.repository;

import com.tumtech.hotelmanagementapp.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Long> {
}
