package com.tumtech.hotelmanagementapp.entity;

import com.tumtech.hotelmanagementapp.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.context.event.EventListener;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long roomId;
    @Column (unique = true)
    private String bookingRef;
    private LocalDateTime checkIn;
    private String emailOfGuest;
    private LocalDateTime checkOut;
    private BigDecimal price;
    private Boolean pay;
    private Long userId;
    private String registerChannel;
    @OneToMany
    private List<Guest> guestList;
    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;
    private  int noOfGuest;
    private int periodInHours;
    private BookingStatus bookingStatus;

}
