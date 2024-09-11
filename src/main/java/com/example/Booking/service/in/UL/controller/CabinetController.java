package com.example.Booking.service.in.UL.controller;

import com.example.Booking.service.in.UL.model.Cabinet;
import com.example.Booking.service.in.UL.service.CabinetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cabinets")
public class CabinetController {

    private final CabinetService cabinetService;

    @Autowired
    public CabinetController(CabinetService cabinetService) {
        this.cabinetService = cabinetService;
    }

    @PostMapping
    public ResponseEntity<Cabinet> createCabinet(@RequestBody Cabinet cabinet) {
        Cabinet savedCabinet = cabinetService.saveCabinet(cabinet);
        return ResponseEntity.ok(savedCabinet);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Cabinet> getCabinetById(@PathVariable Long id) {
        Optional<Cabinet> cabinet = cabinetService.findById(id);
        return cabinet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }



    @PutMapping("/{id}")
    public ResponseEntity<Cabinet> updateCabinet(@PathVariable Long id, @RequestBody Cabinet updatedCabinet) {
        Optional<Cabinet> updated = cabinetService.updateCabinet(id, updatedCabinet);
        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCabinet(@PathVariable Long id) {
        if (cabinetService.deleteCabinet(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/{name}")
    public ResponseEntity<Cabinet> getCabinetByName(@PathVariable String name) {
        Optional<Cabinet> cabinet = cabinetService.findByName(name);
        return cabinet.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping
    public ResponseEntity<List<Cabinet>> getAllCabinets() {
        List<Cabinet> cabinets = cabinetService.getAllCabinets();
        return ResponseEntity.ok(cabinets);
    }
}

