package com.example.Booking.service.in.UL.service.impl;

import com.example.Booking.service.in.UL.model.Cabinet;
import com.example.Booking.service.in.UL.model.Reservation;
import com.example.Booking.service.in.UL.repository.CabinetRepository;
import com.example.Booking.service.in.UL.repository.ReservationRepository;
import com.example.Booking.service.in.UL.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final CabinetRepository cabinetRepository;

    @Autowired
    public ReservationServiceImpl(ReservationRepository reservationRepository, CabinetRepository cabinetRepository) {
        this.reservationRepository = reservationRepository;
        this.cabinetRepository = cabinetRepository;
    }

    @Override
    public Reservation saveReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }


    @Override
    public List<Reservation> getReservationsForCabinet(Long cabinetId, LocalDateTime start, LocalDateTime end) {
        Optional<Cabinet> cabinet = cabinetRepository.findById(cabinetId);
        return cabinet.map(value -> reservationRepository.findByCabinetAndStartTimeBetween(value, start, end))
                .orElseThrow(() -> new IllegalArgumentException("Cabinet not found"));
    }

    @Override
    public List<Reservation> getReservationsByUser(Long userId) {
        return reservationRepository.findByUserId(userId);
    }
}
