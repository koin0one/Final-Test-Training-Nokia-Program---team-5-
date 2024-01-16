package com.finaltraining.hotelbooking.api.hotel;

import com.finaltraining.hotelbooking.dto.HotelEntityDto;
import com.finaltraining.hotelbooking.service.HotelService;
import com.finaltraining.hotelbooking.service.UploadFileToServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/rest/api/hotel", produces = MediaType.APPLICATION_JSON_VALUE)
public class HotelApi {
    @Autowired
    private HotelService m_hotelService;
    @Autowired
    private UploadFileToServer m_uploadFileToServer;

    @RequestMapping(value = "/add-hotel", method = RequestMethod.POST)
    public ResponseEntity addHotel(@RequestBody HotelEntityDto hotelEntityDto){
        try {
            m_hotelService.addHotel(hotelEntityDto);
            return ResponseEntity.ok("Hotel is added");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/find-all-hotel", method = RequestMethod.GET)
    public ResponseEntity findAllHotel(){
        try {
            List<HotelEntityDto> hotelEntityDtos = m_hotelService.findAll();
            return ResponseEntity.ok(hotelEntityDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @RequestMapping(value = "/upload-image/{id}", method = RequestMethod.POST)
    public ResponseEntity uploadImage(@RequestParam("file") MultipartFile file, @PathVariable UUID id){
        try {
            String fileName = m_uploadFileToServer.getCheckSumImageFile(file);
            m_hotelService.uploadHotelImage(fileName, id);
            m_uploadFileToServer.uploadImageToServer(file, fileName,"hotel");
            return ResponseEntity.ok("Upload image successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
