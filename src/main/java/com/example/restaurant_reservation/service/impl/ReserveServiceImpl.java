package com.example.restaurant_reservation.service.impl;

import com.example.restaurant_reservation.dto.ReserveDto;
import com.example.restaurant_reservation.entity.ReservationEntity;
import com.example.restaurant_reservation.repositary.ReserveRepository;
import com.example.restaurant_reservation.service.ReserveService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public ResponseEntity<List<ReserveDto>> getReservations(LocalDate reserveDate) {
        List<ReservationEntity> reservations = (reserveDate != null)
                ? repository.findByReserveDate(reserveDate)
                :repository.findAll();
        List<ReserveDto> reserveDtos = reservations.stream().map(reservationEntity -> {
            ReserveDto dto = new ReserveDto();
            dto.setCustomerId(reservationEntity.getCustomerId());
            dto.setCustomerName(reservationEntity.getCustomerName());
            dto.setReserveDate(reservationEntity.getReserveDate());
            dto.setReserveTime(reservationEntity.getReserveTime());
            dto.setTableSize(reservationEntity.getTableSize());
            return dto;
        }).collect(Collectors.toList());
        return ResponseEntity.ok(reserveDtos);
    }

    @Override
    public ResponseEntity<ReserveDto> updateReservation(Long customerId, ReserveDto reserveDto) {
        if (reserveDto == null){
            return ResponseEntity.badRequest().build();
        }
        ReservationEntity existing = repository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Reservation not found: " + customerId));
        existing.setCustomerName(reserveDto.getCustomerName());
        existing.setReserveDate(reserveDto.getReserveDate());
        existing.setReserveTime(reserveDto.getReserveTime());
        existing.setTableSize(reserveDto.getTableSize());

        ReservationEntity saved = repository.save(existing);

        ReserveDto responseDto = new ReserveDto();
        responseDto.setCustomerId(saved.getCustomerId());
        responseDto.setCustomerName(saved.getCustomerName());
        responseDto.setReserveDate(saved.getReserveDate());
        responseDto.setReserveTime(saved.getReserveTime());
        responseDto.setTableSize(saved.getTableSize());

        return ResponseEntity.ok(responseDto);
    }

    @Override
    public ResponseEntity<Void> deleteReservation(Long customerId) {
        if (!repository.existsById(customerId)){
            throw new RuntimeException("Reservation not found for customerId: " + customerId);
        }
        repository.deleteById(customerId);
        return ResponseEntity.noContent().build();
    }
}
