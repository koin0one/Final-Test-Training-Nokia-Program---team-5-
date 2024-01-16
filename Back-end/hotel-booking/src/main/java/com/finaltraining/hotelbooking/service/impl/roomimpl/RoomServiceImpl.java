package com.finaltraining.hotelbooking.service.impl.roomimpl;

import com.finaltraining.hotelbooking.convert.ConvertRoomType;
import com.finaltraining.hotelbooking.dto.RoomEntityDto;
import com.finaltraining.hotelbooking.dto.RoomTypeEntityDto;
import com.finaltraining.hotelbooking.entity.RoomEntity;
import com.finaltraining.hotelbooking.entity.RoomTypeEntity;
import com.finaltraining.hotelbooking.repository.RoomEntityRepository;
import com.finaltraining.hotelbooking.repository.RoomTypeEntityRepository;
import com.finaltraining.hotelbooking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomTypeEntityRepository m_roomTypeEntityRepository;
    @Autowired
    private ConvertRoomType m_convertRoomType;
    @Autowired
    private RoomEntityRepository m_roomEntityRepository;

    @Override
    public void addRoomType(RoomTypeEntityDto roomTypeEntityDto) {
        RoomTypeEntity roomTypeEntity = m_convertRoomType.convertToDatabaseColumn(roomTypeEntityDto);
        try {
            m_roomTypeEntityRepository.save(roomTypeEntity);
        } catch (RuntimeException e){
            throw new RuntimeException("Room type cannot added");
        }
    }

    @Override
    public List<RoomTypeEntityDto> findAllRoomTypes() {
        List<RoomTypeEntityDto> roomTypeEntityDtos = new ArrayList<>();
        List<RoomTypeEntity> roomTypeEntities = m_roomTypeEntityRepository.findAll();
        if (roomTypeEntities.isEmpty()){
            throw new RuntimeException("The list of room type is empty");
        } else {
            for (RoomTypeEntity roomTypeEntity : roomTypeEntities) {
                RoomTypeEntityDto roomTypeEntityDto = m_convertRoomType.convertToEntityAttribute(roomTypeEntity);
                roomTypeEntityDtos.add(roomTypeEntityDto);
            }
        }
        return roomTypeEntityDtos;
    }

    @Override
    public RoomTypeEntityDto findRoomTypeById(UUID id) {
        RoomTypeEntity roomTypeEntity = m_roomTypeEntityRepository.findById(id);
        if (roomTypeEntity != null) {
            return m_convertRoomType.convertToEntityAttribute(roomTypeEntity);
        } else {
            return null;
        }
    }

    @Override
    public void addRoom(RoomEntityDto roomEntityDto) {

    }

    @Override
    public List<RoomEntityDto> findAllRooms() {
        return null;
    }

    @Override
    public RoomEntityDto findRoomById(UUID id) {
        return null;
    }

    @Override
    public void uploadRoomImage(String fileName, UUID id) {
        RoomEntity room = m_roomEntityRepository.findById(id);
        if (room == null) {
            throw new NullPointerException("Not found");
        } else {
            try {
                room.setImageUrl(fileName);
                m_roomEntityRepository.saveAndFlush(room);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
