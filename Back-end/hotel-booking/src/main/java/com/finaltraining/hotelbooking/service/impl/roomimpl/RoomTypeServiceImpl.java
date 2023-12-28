package com.finaltraining.hotelbooking.service.impl.roomimpl;

import com.finaltraining.hotelbooking.dto.RoomTypeEntityDto;
import com.finaltraining.hotelbooking.repository.RoomTypeEntityRepository;
import com.finaltraining.hotelbooking.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomTypeServiceImpl implements RoomService {
    @Autowired
    private RoomTypeEntityRepository m_roomTypeEntityRepository;

    @Override
    public void addRoomType(RoomTypeEntityDto roomTypeEntityDto) {
        
    }

    @Override
    public List<RoomTypeEntityDto> findAllRoomTypes() {
        return null;
    }

    @Override
    public RoomTypeEntityDto findRoomTypeById(UUID id) {
        return null;
    }
}
