package com.example.restaurant_reservation.service.impl;

import com.example.restaurant_reservation.dto.ReserveDto;
import com.example.restaurant_reservation.entity.ReservationEntity;
import com.example.restaurant_reservation.repositary.ReserveRepository;
import com.example.restaurant_reservation.service.ReserveService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ReserveServiceImpl implements ReserveService {
    private final ReserveRepository repository;

    public ReserveServiceImpl(ReserveRepository repository) {
        this.repository = repository;
    }

    @Override
    public ResponseEntity<ReserveDto> createReservation(ReserveDto reserveDto) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setCustomerName(reserveDto.getCustomerName());
        reservationEntity.setReserveDate(reserveDto.getReserveDate());
        reservationEntity.setReserveTime(reserveDto.getReserveTime());
        reservationEntity.setTableSize(reserveDto.getTableSize());

        ReservationEntity saved = repository.save(reservationEntity);

        ReserveDto responseDto = new ReserveDto();
        responseDto.setCustomerId(saved.getCustomerId());
        responseDto.setCustomerName(saved.getCustomerName());
        responseDto.setReserveDate(saved.getReserveDate());
        responseDto.setReserveTime(saved.getReserveTime());
        responseDto.setTableSize(saved.getTableSize());

        return ResponseEntity.ok(responseDto);
    }
}
