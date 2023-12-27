package com.finaltraining.hotelbooking.repository;

import com.finaltraining.hotelbooking.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findById(UUID id);
}