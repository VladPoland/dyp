package com.example.Booking.service.in.UL.service;

import com.example.Booking.service.in.UL.model.Cabinet;

import java.util.List;
import java.util.Optional;

public interface CabinetService {
    Cabinet saveCabinet(Cabinet cabinet);
    Optional<Cabinet> findByName(String name);
    List<Cabinet> getAllCabinets();

    Optional<Cabinet> findById(Long id);

    Optional<Cabinet> updateCabinet(Long id, Cabinet updatedCabinet);

    boolean deleteCabinet(Long id);
    // Додаткові методи за потребою
}
