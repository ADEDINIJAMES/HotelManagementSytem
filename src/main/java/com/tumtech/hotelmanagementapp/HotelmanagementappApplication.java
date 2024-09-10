package com.tumtech.hotelmanagementapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
@Async
public class HotelmanagementappApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelmanagementappApplication.class, args);
	}

}
