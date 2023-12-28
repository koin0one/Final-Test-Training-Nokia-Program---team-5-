package com.finaltraining.hotelbooking.service.impl.userimpl;

import com.finaltraining.hotelbooking.convert.ConvertUser;
import com.finaltraining.hotelbooking.dto.UserEntityDto;
import com.finaltraining.hotelbooking.entity.RoleEntity;
import com.finaltraining.hotelbooking.entity.UserEntity;
import com.finaltraining.hotelbooking.repository.RoleEntityRepository;
import com.finaltraining.hotelbooking.repository.UserEntityRepository;
import com.finaltraining.hotelbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityRepository m_userEntityRepository;

    @Autowired
    private RoleEntityRepository m_roleRepository;

    @Autowired
    private ConvertUser m_converUser;

    private final String guest_role_name = "guest";

    public String hashPass(String password){
        String hashPass = DigestUtils.md5DigestAsHex(password.getBytes()).toUpperCase();
        return hashPass;
    }

    @Override
    public void AddUser(UserEntityDto userEntityDto) {
        UserEntity userEntity = m_converUser.convertToDatabaseColumn(userEntityDto);
        if (m_userEntityRepository.findByUserName(userEntity.getUserName()) != null) {
            throw new RuntimeException("User already exists!");
        } else {
            if (userEntityDto.getPassWord().length() == 32){
                userEntity.setPassWord(userEntityDto.getPassWord());
            } else {
                userEntity.setPassWord(hashPass(userEntityDto.getPassWord()));
            }
            RoleEntity roleEntity;
            if (userEntityDto.getRoleId() == null) {
                roleEntity = m_roleRepository.findByRoleName(guest_role_name);
            } else {
                roleEntity = m_roleRepository.findById(userEntityDto.getRoleId());
            }
            userEntity.setRole(roleEntity);
            m_userEntityRepository.save(userEntity);
        }
    }

    @Override
    public List<UserEntityDto> findAllUser() {
        List<UserEntityDto> listUserDto = new ArrayList<>();
        List<UserEntity> listUserEntity = m_userEntityRepository.findAll();
        for (UserEntity userEntity : listUserEntity){
            if (userEntity != null){
                UserEntityDto userEntityDto = m_converUser.convertToEntityAttribute(userEntity);
                userEntityDto.setRoleId(userEntity.getRole().getId());
                listUserDto.add(userEntityDto);
            }
        }
        return listUserDto;
    }

    @Override
    public UserEntityDto findUserById(UUID id) {
        UserEntity userEntity = m_userEntityRepository.findById(id);
        UserEntityDto userEntityDto = m_converUser.convertToEntityAttribute(userEntity);
        userEntityDto.setRoleId(userEntity.getRole().getId());
        return userEntityDto;
    }

    @Override
    public UserEntityDto findUserByUserName(String userName) {
        UserEntity userEntity = m_userEntityRepository.findByUserName(userName);
        UserEntityDto userEntityDto = m_converUser.convertToEntityAttribute(userEntity);
        userEntityDto.setRoleId(userEntity.getRole().getId());
        return userEntityDto;
    }

    @Override
    public UserEntityDto updateUserById(UserEntityDto userEntityDto) {
        UUID id = userEntityDto.getId();
        UserEntity userEntity = m_userEntityRepository.getById(id);
        RoleEntity roleEntity = m_roleRepository.findById(userEntityDto.getRoleId());
        if (userEntity == null) {
            throw new RuntimeException("User is not exists!");
        } else {
            userEntity.setFirstName(userEntityDto.getFirstName());
            userEntity.setLastName(userEntityDto.getLastName());
            userEntity.setGender(userEntityDto.getGender());
            userEntity.setAge(userEntityDto.getAge());
            userEntity.setEmail(userEntityDto.getEmail());
            userEntity.setAddress(userEntityDto.getAddress());
            userEntity.setPhoneNumber(userEntityDto.getPhoneNumber());
            userEntity.setPinCode(userEntityDto.getPinCode());
            userEntity.setRole(roleEntity);
            m_userEntityRepository.save(userEntity);
            userEntityDto = m_converUser.convertToEntityAttribute(m_userEntityRepository.findById(id));
            return userEntityDto;
        }
    }

    @Override
    public void deleteUserById(UUID id) {
        try {
            m_userEntityRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Can not delete user!");
        }
    }

    @Override
    public void deleteUserByUserName(String username) {
        try {
            m_userEntityRepository.deleteByUserName(username);
        } catch (Exception e) {
            throw new RuntimeException("Can not delete user!");
        }
    }


}
