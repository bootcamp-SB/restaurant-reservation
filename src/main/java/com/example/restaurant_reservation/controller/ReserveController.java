package com.example.restaurant_reservation.controller;

import com.example.restaurant_reservation.dto.ReserveDto;
import com.example.restaurant_reservation.entity.ReservationEntity;
import com.example.restaurant_reservation.service.ReserveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

   @GetMapping("/bookings")
    public ResponseEntity<List<ReserveDto>> getReservations(@RequestParam(required = false)LocalDate reserveDate){
       return reserveService.getReservations(reserveDate);
   }

    @PutMapping("/update/{customerId}")
    public ResponseEntity<ReserveDto> updateReservation(@PathVariable Long customerId, @RequestBody ReserveDto reserveDto) {
        return reserveService.updateReservation(customerId, reserveDto);
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<Void> deleteReservation(@PathVariable Long customerId){
       return reserveService.deleteReservation(customerId);
    }
}
