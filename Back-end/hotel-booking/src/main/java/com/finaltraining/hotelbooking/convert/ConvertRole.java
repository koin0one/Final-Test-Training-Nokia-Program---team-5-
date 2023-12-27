package com.finaltraining.hotelbooking.convert;

import com.finaltraining.hotelbooking.dto.RoleEntityDto;
import com.finaltraining.hotelbooking.entity.RoleEntity;
import com.finaltraining.hotelbooking.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertRole {

    @Autowired
    private ModelMapper m_modelMapper;

    public RoleEntity convertToDatabaseColumn(RoleEntityDto roleEntityDto){
        return m_modelMapper.map(roleEntityDto, RoleEntity.class);
    }

    public RoleEntityDto convertToEntityAttribute(RoleEntity roleEntity){
        return m_modelMapper.map(roleEntity, RoleEntityDto.class);
    }
}
