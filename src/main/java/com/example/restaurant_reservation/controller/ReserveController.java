package com.example.restaurant_reservation.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReserveController {
    @GetMapping("/hello")
    public String helloApi(){
        return "Hello SpringBoot";
    }

    @GetMapping("/send-email/{email}")
    public ResponseEntity<String> email(@PathVariable String email){
        String format = String.format("Hello %s", email);
        return ResponseEntity.ok(format);
    }
}
