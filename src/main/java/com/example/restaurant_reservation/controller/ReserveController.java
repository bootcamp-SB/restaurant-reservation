package com.example.restaurant_reservation.controller;

import com.example.restaurant_reservation.dto.ReserveDto;
import com.example.restaurant_reservation.entity.ReservationEntity;
import com.example.restaurant_reservation.service.ReserveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ReserveController {
   private final ReserveService reserveService;

   public ReserveController(ReserveService reserveService){
       this.reserveService = reserveService;
   }

   @PostMapping("/book")
   public ResponseEntity<ReserveDto> createReservation(@RequestBody ReserveDto reserveDto){
       return reserveService.createReservation(reserveDto);
   }
}
