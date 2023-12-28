package com.finaltraining.hotelbooking.repository;

import com.finaltraining.hotelbooking.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoomEntityRepository extends JpaRepository<RoomEntity, UUID> {
}
