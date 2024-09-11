package com.example.Booking.service.in.UL.service;

import com.example.Booking.service.in.UL.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {
    Reservation saveReservation(Reservation reservation);
    List<Reservation> getReservationsForCabinet(Long cabinetId, LocalDateTime start, LocalDateTime end);
    List<Reservation> getReservationsByUser(Long userId);
    // Додаткові методи за потребою
}
