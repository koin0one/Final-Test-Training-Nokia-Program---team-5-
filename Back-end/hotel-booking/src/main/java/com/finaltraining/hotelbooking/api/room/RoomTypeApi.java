package com.finaltraining.hotelbooking.api.room;

import com.finaltraining.hotelbooking.dto.RoomTypeEntityDto;
import com.finaltraining.hotelbooking.service.RoomService;
import com.finaltraining.hotelbooking.service.UploadFileToServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/rest/api/room-type", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomTypeApi {
    @Autowired
    private RoomService m_roomService;
    @Autowired
    private UploadFileToServer m_uploadFileToServer;

    @RequestMapping(value = "/add-room-type", method = RequestMethod.POST)
    public ResponseEntity addRoomType(@RequestBody RoomTypeEntityDto roomTypeEntityDto){
        if (roomTypeEntityDto.getRoomTypeName() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Missing parameters");
        } else {
            try {
                m_roomService.addRoomType(roomTypeEntityDto);
                return ResponseEntity.ok("Room type is added");
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
            }
        }
    }

    @RequestMapping(value = "/find-all-room-type", method = RequestMethod.GET)
    public ResponseEntity findAllRoomType(){
        try {
            List<RoomTypeEntityDto> roomTypeEntityDtos = m_roomService.findAllRoomTypes();
            return ResponseEntity.ok(roomTypeEntityDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
