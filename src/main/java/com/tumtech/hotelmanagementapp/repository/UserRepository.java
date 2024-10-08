package com.tumtech.hotelmanagementapp.repository;

import com.tumtech.hotelmanagementapp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users, Long> {
   Optional< Users >findByEmail (String username);
}
