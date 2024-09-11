package com.example.Booking.service.in.UL.controller;

import com.example.Booking.service.in.UL.model.Reservation;
import com.example.Booking.service.in.UL.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
        Reservation savedReservation = reservationService.saveReservation(reservation);
        return ResponseEntity.ok(savedReservation);
    }

    @GetMapping("/cabinet/{cabinetId}")
    public ResponseEntity<List<Reservation>> getReservationsForCabinet(
            @PathVariable Long cabinetId,
            @RequestParam LocalDateTime start,
            @RequestParam LocalDateTime end) {
        List<Reservation> reservations = reservationService.getReservationsForCabinet(cabinetId, start, end);
        return ResponseEntity.ok(reservations);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Reservation>> getReservationsByUser(@PathVariable Long userId) {
        List<Reservation> reservations = reservationService.getReservationsByUser(userId);
        return ResponseEntity.ok(reservations);
    }
}
