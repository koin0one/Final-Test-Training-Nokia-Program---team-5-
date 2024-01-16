package com.finaltraining.hotelbooking.service;

import com.finaltraining.hotelbooking.dto.RoomEntityDto;
import com.finaltraining.hotelbooking.dto.RoomTypeEntityDto;
import com.finaltraining.hotelbooking.entity.RoomEntity;

import java.util.List;
import java.util.UUID;

public interface RoomService {
    // Room type
    void addRoomType(RoomTypeEntityDto roomTypeEntityDto);
    List<RoomTypeEntityDto> findAllRoomTypes();
    RoomTypeEntityDto findRoomTypeById(UUID id);
    // Room
    void addRoom(RoomEntityDto roomEntityDto);
    List<RoomEntityDto> findAllRooms();
    RoomEntityDto findRoomById(UUID id);
    void uploadRoomImage(String fileName, UUID id);
}
