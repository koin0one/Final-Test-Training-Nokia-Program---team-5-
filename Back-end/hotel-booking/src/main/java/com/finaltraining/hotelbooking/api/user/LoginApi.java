package com.finaltraining.hotelbooking.api.user;

import com.finaltraining.hotelbooking.dto.RoleEntityDto;
import com.finaltraining.hotelbooking.dto.UserEntityDto;
import com.finaltraining.hotelbooking.service.RoleService;
import com.finaltraining.hotelbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/rest/api/", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoginApi {
    @Autowired
    private UserService m_userService;
    @Autowired
    private RoleService m_roleService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @SuppressWarnings("unchecked")
    public <T> ResponseEntity login(@RequestBody UserEntityDto userEntityDto){
        String username = userEntityDto.getUserName();
        String password = userEntityDto.getPassWord();
        if (username == null || password == null){
            return ResponseEntity.badRequest().body("Missing parameter!");
        } else {
            userEntityDto = m_userService.findUserByUserNameAndPassWord(username, password);
            if (userEntityDto == null){
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("The username or password you entered is incorrect");
            } else {
                RoleEntityDto roleEntityDto = m_roleService.findRoleById(userEntityDto.getRoleId());
                Map<String, T> objects = new HashMap<>();
                objects.put("user", (T) userEntityDto);
                objects.put("role", (T) roleEntityDto);
                return ResponseEntity.status(HttpStatus.OK).body(objects);
            }
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(@RequestBody UserEntityDto userEntityDto){
        try {
            m_userService.AddUser(userEntityDto);
            return ResponseEntity.ok("Registered Successfully");
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
