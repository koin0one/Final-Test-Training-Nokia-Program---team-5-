package com.finaltraining.hotelbooking.service.impl.hotelimpl;

import com.finaltraining.hotelbooking.convert.ConvertHotel;
import com.finaltraining.hotelbooking.dto.HotelEntityDto;
import com.finaltraining.hotelbooking.entity.HotelEntity;
import com.finaltraining.hotelbooking.entity.RoomEntity;
import com.finaltraining.hotelbooking.repository.HotelEntityRepository;
import com.finaltraining.hotelbooking.service.HotelService;
import com.finaltraining.hotelbooking.service.UploadFileToServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelEntityRepository m_hotelEntityRepository;
    @Autowired
    private ConvertHotel m_convertHotel;
    @Autowired
    private UploadFileToServer m_uploadFileToServer;

    @Override
    public void addHotel(HotelEntityDto hotelEntityDto) {
        if (hotelEntityDto.getHotelName() == null) {
            throw new RuntimeException("Missing parameters");
        } else {
            try {
                HotelEntity hotelEntity = m_convertHotel.convertToDatabaseColumn(hotelEntityDto);
                m_hotelEntityRepository.save(hotelEntity);
            } catch (RuntimeException e) {
                throw new RuntimeException("Hotel cannot added");
            }
        }
    }

    @Override
    public HotelEntityDto findHotelById(UUID id) {
        HotelEntity hotelEntity = m_hotelEntityRepository.findById(id);
        if (hotelEntity == null) {
            return null;
        } else {
            HotelEntityDto hotelEntityDto = m_convertHotel.convertToEntityAttribute(hotelEntity);
            return hotelEntityDto;
        }
    }

    @Override
    public List<HotelEntityDto> findAll() {
        List<HotelEntityDto> hotelEntityDtos = new ArrayList<>();
        List<HotelEntity> hotelEntities = m_hotelEntityRepository.findAll();
        if (hotelEntities.isEmpty()){
            throw new RuntimeException("The list of hotel is empty");
        } else {
            for (HotelEntity hotelEntity : hotelEntities) {
                HotelEntityDto hotelEntityDto = m_convertHotel.convertToEntityAttribute(hotelEntity);
                hotelEntityDtos.add(hotelEntityDto);
            }
        }
        return hotelEntityDtos;
    }

    @Override
    public void uploadHotelImage(String fileName, UUID id) {
        HotelEntity hotel = m_hotelEntityRepository.findById(id);
        if (hotel == null) {
            throw new NullPointerException("Not found");
        } else {
            try {
                hotel.setImageURL(fileName);
                m_hotelEntityRepository.saveAndFlush(hotel);
            } catch (RuntimeException e) {
                throw new RuntimeException(e.getMessage());
            }
        }
    }
}
