package com.finaltraining.hotelbooking.api.room;

import com.finaltraining.hotelbooking.service.RoomService;
import com.finaltraining.hotelbooking.service.UploadFileToServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@RestController
@RequestMapping(value = "/rest/api/room", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoomApi {
    @Autowired
    private RoomService m_roomService;
    @Autowired
    private UploadFileToServer m_uploadFileToServer;

    @RequestMapping(value = "/upload-image/{id}", method = RequestMethod.POST)
    public ResponseEntity uploadImage(@RequestParam("file") MultipartFile file, @PathVariable UUID id){
        try {
            String fileName = m_uploadFileToServer.getCheckSumImageFile(file);
            m_roomService.uploadRoomImage(fileName, id);
            m_uploadFileToServer.uploadImageToServer(file, fileName,"room");
            return ResponseEntity.ok("Upload image successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
