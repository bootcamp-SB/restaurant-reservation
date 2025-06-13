package com.example.restaurant_reservation.repositary;

import com.example.restaurant_reservation.entity.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReserveRepository extends JpaRepository<ReservationEntity, Long> {
    List<ReservationEntity> findByReserveDate(LocalDate reserveDate);
}
