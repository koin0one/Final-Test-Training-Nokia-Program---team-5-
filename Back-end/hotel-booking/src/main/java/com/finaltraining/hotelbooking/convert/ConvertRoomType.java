package com.finaltraining.hotelbooking.convert;

import com.finaltraining.hotelbooking.dto.RoomTypeEntityDto;
import com.finaltraining.hotelbooking.entity.RoomTypeEntity;
import jakarta.persistence.Converter;
import jakarta.persistence.AttributeConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertRoomType{
    @Autowired
    private ModelMapper m_modelMapper;

    public RoomTypeEntity convertToDatabaseColumn(RoomTypeEntityDto roomTypeEntityDto) {
        return m_modelMapper.map(roomTypeEntityDto, RoomTypeEntity.class);
    }

    public RoomTypeEntityDto convertToEntityAttribute(RoomTypeEntity roomTypeEntity) {
        return m_modelMapper.map(roomTypeEntity, RoomTypeEntityDto.class);
    }
}
