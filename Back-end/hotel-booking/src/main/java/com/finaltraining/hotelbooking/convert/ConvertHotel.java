package com.finaltraining.hotelbooking.convert;

import com.finaltraining.hotelbooking.dto.HotelEntityDto;
import com.finaltraining.hotelbooking.entity.HotelEntity;
import jakarta.persistence.Converter;
import jakarta.persistence.AttributeConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConvertHotel {
    @Autowired
    private ModelMapper m_modelMapper;

    public HotelEntity convertToDatabaseColumn(HotelEntityDto hotelEntityDto) {
        return m_modelMapper.map(hotelEntityDto, HotelEntity.class);
    }

    public HotelEntityDto convertToEntityAttribute(HotelEntity hotelEntity) {
        return m_modelMapper.map(hotelEntity, HotelEntityDto.class);
    }
}
