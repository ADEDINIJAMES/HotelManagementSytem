package com.tumtech.hotelmanagementapp.repository;

import com.tumtech.hotelmanagementapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
    Users findByEmail (String username);
}
