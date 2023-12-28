package com.finaltraining.hotelbooking.service;

import com.finaltraining.hotelbooking.dto.RoomTypeEntityDto;

import java.util.List;
import java.util.UUID;

public interface RoomService {
    // Room type
    void addRoomType(RoomTypeEntityDto roomTypeEntityDto);
    List<RoomTypeEntityDto> findAllRoomTypes();
    RoomTypeEntityDto findRoomTypeById(UUID id);
}
