package com.finaltraining.hotelbooking.service;

import com.finaltraining.hotelbooking.dto.UserEntityDto;
import com.finaltraining.hotelbooking.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void AddUser(UserEntityDto user);

    List<UserEntityDto> findAllUser();

    UserEntityDto findUserById(UUID id);

    UserEntityDto findUserByUserName(String userName);

    UserEntityDto updateUserById(UserEntityDto userEntityDto);

    void deleteUserById(UUID id);

    void deleteUserByUserName(String username);
}
