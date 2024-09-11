package com.example.Booking.service.in.UL.service.impl;

import com.example.Booking.service.in.UL.model.Cabinet;
import com.example.Booking.service.in.UL.repository.CabinetRepository;
import com.example.Booking.service.in.UL.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CabinetServiceImpl implements CabinetService {

    private final CabinetRepository cabinetRepository;

    @Autowired
    public CabinetServiceImpl(CabinetRepository cabinetRepository) {
        this.cabinetRepository = cabinetRepository;
    }

    @Override
    public Cabinet saveCabinet(Cabinet cabinet) {
        return cabinetRepository.save(cabinet);
    }

    @Override
    public Optional<Cabinet> findByName(String name) {
        return cabinetRepository.findByName(name);
    }

    @Override
    public List<Cabinet> getAllCabinets() {
        return cabinetRepository.findAll();
    }

    @Override
    public Optional<Cabinet> findById(Long id) {
        return cabinetRepository.findById(id);
    }

    @Override
    public Optional<Cabinet> updateCabinet(Long id, Cabinet updatedCabinet) {
        return cabinetRepository.findById(id).map(cabinet -> {
            cabinet.setName(updatedCabinet.getName());
            cabinet.setLocation(updatedCabinet.getLocation());
            cabinet.setCapacity(updatedCabinet.getCapacity());
            return cabinetRepository.save(cabinet);
        });
    }

    @Override
    public boolean deleteCabinet(Long id) {
        if (cabinetRepository.existsById(id)) {
            cabinetRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
