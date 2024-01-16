package com.finaltraining.hotelbooking.repository;

import com.finaltraining.hotelbooking.dto.HotelEntityDto;
import com.finaltraining.hotelbooking.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HotelEntityRepository extends JpaRepository<HotelEntity, Long> {
    HotelEntity findById(UUID id);
}