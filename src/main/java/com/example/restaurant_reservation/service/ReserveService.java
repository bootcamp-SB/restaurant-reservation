package com.example.restaurant_reservation.service;

import com.example.restaurant_reservation.dto.ReserveDto;
import org.springframework.http.ResponseEntity;

public interface ReserveService {
    ResponseEntity<ReserveDto> createReservation(ReserveDto reserveDto);
}
