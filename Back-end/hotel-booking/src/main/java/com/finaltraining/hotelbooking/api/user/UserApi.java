package com.finaltraining.hotelbooking.api.user;

import com.finaltraining.hotelbooking.dto.UserEntityDto;
import com.finaltraining.hotelbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/rest/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserApi {

    @Autowired
    private UserService m_userService;

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public ResponseEntity addUser(@RequestBody UserEntityDto userEntityDto){
        try {
            m_userService.addUser(userEntityDto);
            return ResponseEntity.ok("User is added!");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/find-all-user", method = RequestMethod.GET)
    public ResponseEntity findAllUser(){
        List<UserEntityDto> userEntityDtos = m_userService.findAllUser();
        if (userEntityDtos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The list of users is empty");
        } else {
            return ResponseEntity.ok(userEntityDtos);
        }
    }

    @RequestMapping(value = "/find-user/id/{id}", method = RequestMethod.GET)
    public ResponseEntity findUserById(@PathVariable("id") UUID id){
        try {
            UserEntityDto userEntityDto = m_userService.findUserById(id);
            if (userEntityDto != null) {
                return ResponseEntity.ok(userEntityDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @RequestMapping(value = "/find-user/username/{username}", method = RequestMethod.GET)
    public ResponseEntity findUserByUserName(@PathVariable("username") String username){
        try {
            UserEntityDto userEntityDto = m_userService.findUserByUserName(username);
            if (userEntityDto != null) {
                return ResponseEntity.ok(userEntityDto);
            } else {
                return ResponseEntity.notFound().build();
            }
        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    @RequestMapping(value = "/update-user", method = RequestMethod.PUT)
    public ResponseEntity updateUserById(@RequestBody UserEntityDto userEntityDto){
        try {
            m_userService.updateUserById(userEntityDto);
            return ResponseEntity.ok("User is updated!");
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

}
