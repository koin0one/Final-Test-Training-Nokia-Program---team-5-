package com.finaltraining.hotelbooking.repository;

import com.finaltraining.hotelbooking.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findById(UUID id);
    UserEntity findByUserName(String userName);
    void deleteById(UUID id);
    void deleteByUserName(String userName);
    UserEntity getById(UUID id);
    UserEntity findUserByUserNameAndPassWord(String userName, String passWord);
}