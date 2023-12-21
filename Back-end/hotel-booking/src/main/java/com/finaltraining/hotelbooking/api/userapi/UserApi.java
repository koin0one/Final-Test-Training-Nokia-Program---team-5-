package com.finaltraining.hotelbooking.api.userapi;

import com.finaltraining.hotelbooking.dto.UserEntityDto;
import com.finaltraining.hotelbooking.service.UserService;
import com.finaltraining.hotelbooking.utils.ResponseObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class UserApi {

    @Autowired
    private UserService m_userService;

    @RequestMapping(value = "/add-user", method = RequestMethod.POST)
    public String addUser(@RequestBody UserEntityDto userEntityDto){
        m_userService.AddUser(userEntityDto);
        return null;
    }

    @RequestMapping(value = "/find-all-user", method = RequestMethod.GET)
    public Map<String, List<UserEntityDto>> findAllUser(){
        List<UserEntityDto> findAllUser = m_userService.findAllUser();
        Map<String, List<UserEntityDto>> coordinates = new HashMap<>();
        coordinates.put("obj", findAllUser);
        return coordinates;
    }

    @RequestMapping(value = "/find-user/id/{id}", method = RequestMethod.GET)
    public <T> Map<String, T> findUserById(@PathVariable("id") UUID id){
        UserEntityDto userEntityDto = m_userService.findUserById(id);
        return (Map<String, T>) ResponseObject.responseRequest(userEntityDto);
    }

    @RequestMapping(value = "/find-user/username/{username}", method = RequestMethod.GET)
    public <T> Map<String, T> findUserByUserName(@PathVariable("username") String username){
        UserEntityDto userEntityDto = m_userService.findUserByUserName(username);
        return (Map<String, T>) ResponseObject.responseRequest(userEntityDto);
    }

}
