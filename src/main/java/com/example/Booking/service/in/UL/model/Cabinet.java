package com.example.Booking.service.in.UL.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cabinets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cabinet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer capacity;
}

