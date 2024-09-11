package com.example.Booking.service.in.UL.service;

import com.example.Booking.service.in.UL.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User saveUser(User user);
    Optional<User> findByUsername(String username);
    List<User> getAllUsers();
    // Додаткові методи за потребою
}
