package com.example.Booking.service.in.UL.repository;



import com.example.Booking.service.in.UL.model.Reservation;
import com.example.Booking.service.in.UL.model.Cabinet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByCabinetAndStartTimeBetween(Cabinet cabinet, LocalDateTime start, LocalDateTime end);
    List<Reservation> findByUserId(Long userId);
}

