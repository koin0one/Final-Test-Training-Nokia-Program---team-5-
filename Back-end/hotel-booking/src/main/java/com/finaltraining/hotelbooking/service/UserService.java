package com.finaltraining.hotelbooking.service;

import com.finaltraining.hotelbooking.dto.UserEntityDto;

import java.util.List;
import java.util.UUID;

public interface UserService {
    void addUser(UserEntityDto userEntityDto);

    List<UserEntityDto> findAllUser();

    UserEntityDto findUserById(UUID id);

    UserEntityDto findUserByUserName(String userName);

    UserEntityDto findUserByUserNameAndPassWord(String userName, String passWord);

    UserEntityDto updateUserById(UserEntityDto userEntityDto);

    void deleteUserById(UUID id);

    void deleteUserByUserName(String userName);
}
