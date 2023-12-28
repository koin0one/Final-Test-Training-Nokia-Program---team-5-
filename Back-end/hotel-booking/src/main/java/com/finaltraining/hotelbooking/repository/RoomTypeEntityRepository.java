package com.finaltraining.hotelbooking.repository;

import com.finaltraining.hotelbooking.entity.RoomTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoomTypeEntityRepository extends JpaRepository<RoomTypeEntity, UUID> {
}