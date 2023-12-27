package com.finaltraining.hotelbooking.service;

import com.finaltraining.hotelbooking.dto.RoleEntityDto;
import com.finaltraining.hotelbooking.entity.RoleEntity;

import java.util.List;
import java.util.UUID;

public interface RoleService {
    void addRole(RoleEntityDto roleEntityDto);
    List<RoleEntityDto> findAllRole();
    RoleEntityDto findRoleById(UUID id);
    void deleteRoleById(UUID id);
}
