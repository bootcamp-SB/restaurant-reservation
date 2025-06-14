package com.example.restaurant_reservation.service;

import com.example.restaurant_reservation.dto.ReserveDto;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.List;

public interface ReserveService {
    ResponseEntity<ReserveDto> createReservation(ReserveDto reserveDto);
    ResponseEntity<List<ReserveDto>> getReservations(LocalDate reserveDate);
    ResponseEntity<ReserveDto> updateReservation(Long customerId, ReserveDto reserveDto);
    ResponseEntity<Void> deleteReservation(Long customerId);
}
