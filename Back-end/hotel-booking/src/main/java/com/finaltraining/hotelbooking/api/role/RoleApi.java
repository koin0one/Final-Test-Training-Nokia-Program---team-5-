package com.finaltraining.hotelbooking.api.role;

import com.finaltraining.hotelbooking.dto.RoleEntityDto;
import com.finaltraining.hotelbooking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/rest/api/role", produces = MediaType.APPLICATION_JSON_VALUE)
public class RoleApi {
    @Autowired
    private RoleService m_RoleService;

    @RequestMapping(value = "/add-role", method = RequestMethod.POST)
    public ResponseEntity addRole(@RequestBody RoleEntityDto roleEntityDto){
        try {
            m_RoleService.addRole(roleEntityDto);
            return ResponseEntity.ok("Role is added");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/find-all-role", method = RequestMethod.GET)
    public ResponseEntity findAllRole(){
        List<RoleEntityDto> roleEntityDtos = m_RoleService.findAllRole();
        if (roleEntityDtos.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The list of roles is empty");
        } else {
            return ResponseEntity.ok(roleEntityDtos);
        }
    }

    @RequestMapping(value = "/find-role/id/{id}", method = RequestMethod.GET)
    public ResponseEntity findRoleById(@PathVariable("id") UUID id){
        RoleEntityDto roleEntityDto = m_RoleService.findRoleById(id);
        if (roleEntityDto != null) {
            return ResponseEntity.ok(roleEntityDto);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Role not found");
        }
    }
}
