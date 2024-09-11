package com.example.Booking.service.in.UL.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        return "Привіт! Система резервації кабінетів запущена.";
    }
}


