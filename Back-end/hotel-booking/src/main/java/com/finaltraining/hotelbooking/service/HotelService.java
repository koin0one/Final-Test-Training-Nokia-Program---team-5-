package com.finaltraining.hotelbooking.service;

import com.finaltraining.hotelbooking.dto.HotelEntityDto;

import java.util.List;
import java.util.UUID;

public interface HotelService {
    void addHotel(HotelEntityDto hotelEntityDto);
    HotelEntityDto findHotelById(UUID id);
    List<HotelEntityDto> findAll();
    void uploadHotelImage(String fileName, UUID id);
}
