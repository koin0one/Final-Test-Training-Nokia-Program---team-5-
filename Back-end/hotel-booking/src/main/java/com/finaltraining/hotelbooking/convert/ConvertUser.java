package com.finaltraining.hotelbooking.convert;

import com.finaltraining.hotelbooking.dto.UserEntityDto;
import com.finaltraining.hotelbooking.entity.UserEntity;
import jakarta.persistence.AttributeConverter;
import org.springframework.stereotype.Component;

@Component
public class ConvertUser implements AttributeConverter<UserEntityDto, UserEntity> {

    @Override
    public UserEntity convertToDatabaseColumn(UserEntityDto userEntityDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUserName(userEntityDto.getUserName());
        userEntity.setFirstName(userEntityDto.getFirstName());
        userEntity.setLastName(userEntityDto.getLastName());
        userEntity.setGender(userEntityDto.getGender());
        userEntity.setAge(userEntityDto.getAge());
        userEntity.setEmail(userEntityDto.getEmail());
        userEntity.setAddress(userEntityDto.getAddress());
        userEntity.setPhoneNumber(userEntityDto.getPhoneNumber());
        userEntity.setPinCode(userEntityDto.getPinCode());
        return userEntity;
    }

    @Override
    public UserEntityDto convertToEntityAttribute(UserEntity userEntity) {
        UserEntityDto userEntityDto = new UserEntityDto();
        userEntityDto.setId(userEntity.getId());
        userEntityDto.setFirstName(userEntity.getFirstName());
        userEntityDto.setUserName(userEntity.getUserName());
        userEntityDto.setLastName(userEntity.getLastName());
        userEntityDto.setGender(userEntity.getGender());
        userEntityDto.setAge(userEntity.getAge());
        userEntityDto.setEmail(userEntity.getEmail());
        userEntityDto.setAddress(userEntity.getAddress());
        userEntityDto.setPhoneNumber(userEntity.getPhoneNumber());
        userEntityDto.setPinCode(userEntity.getPinCode());
        return userEntityDto;
    }
}
