package com.finaltraining.hotelbooking.service.impl.userimpl;

import com.finaltraining.hotelbooking.convert.ConvertUser;
import com.finaltraining.hotelbooking.dto.UserEntityDto;
import com.finaltraining.hotelbooking.entity.RoleEntity;
import com.finaltraining.hotelbooking.entity.UserEntity;
import com.finaltraining.hotelbooking.repository.RoleEntityRepository;
import com.finaltraining.hotelbooking.repository.UserEntityRepository;
import com.finaltraining.hotelbooking.service.UserService;
import com.finaltraining.hotelbooking.utils.EncodeSecret;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    private ConvertUser m_convertUser;

    private final String GUEST_ROLE_NAME = "guest";

    private final String DELETE_ERROR_MESSAGE = "This user cannot be deleted";

    @Override
    public void addUser(UserEntityDto userEntityDto) {
        UserEntity userEntity = m_convertUser.convertToDatabaseColumn(userEntityDto);
        if (m_userEntityRepository.findByUserName(userEntity.getUserName()) != null) {
            throw new RuntimeException("Username is already in use");
        } else {
            if (userEntityDto.getPassWord().length() == 32){
                userEntity.setPassWord(userEntityDto.getPassWord());
            } else {
                userEntity.setPassWord(EncodeSecret.hashPass(userEntityDto.getPassWord()));
            }
            RoleEntity roleEntity;
            if (userEntityDto.getRoleId() == null) {
                roleEntity = m_roleRepository.findByRoleName(GUEST_ROLE_NAME);
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
                UserEntityDto userEntityDto = m_convertUser.convertToEntityAttribute(userEntity);
                userEntityDto.setRoleId(userEntity.getRole().getId());
                listUserDto.add(userEntityDto);
            }
        }
        return listUserDto;
    }

    @Override
    public UserEntityDto findUserById(UUID id) {
        UserEntity userEntity = m_userEntityRepository.findById(id);
        UserEntityDto userEntityDto = m_convertUser.convertToEntityAttribute(userEntity);
        userEntityDto.setRoleId(userEntity.getRole().getId());
        return userEntityDto;
    }

    @Override
    public UserEntityDto findUserByUserName(String userName) {
        UserEntity userEntity = m_userEntityRepository.findByUserName(userName);
        UserEntityDto userEntityDto = m_convertUser.convertToEntityAttribute(userEntity);
        userEntityDto.setRoleId(userEntity.getRole().getId());
        return userEntityDto;
    }

    @Override
    public UserEntityDto findUserByUserNameAndPassWord(String userName, String passWord) {
        if (passWord.length() != 32){
            passWord = EncodeSecret.hashPass(passWord);
        }
        UserEntity userEntity = m_userEntityRepository.findUserByUserNameAndPassWord(userName, passWord);
        if (userEntity != null){
            UserEntityDto userEntityDto = m_convertUser.convertToEntityAttribute(userEntity);
            userEntityDto.setRoleId(userEntity.getRole().getId());
            return userEntityDto;
        } else {
            return null;
        }
    }

    @Override
    public UserEntityDto updateUserById(UserEntityDto userEntityDto) {
        UUID id = userEntityDto.getId();
        UserEntity userEntity = m_userEntityRepository.getById(id);
        RoleEntity roleEntity = m_roleRepository.findById(userEntityDto.getRoleId());
        if (userEntity == null) {
            throw new RuntimeException("User not found");
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
            userEntityDto = m_convertUser.convertToEntityAttribute(m_userEntityRepository.findById(id));
            return userEntityDto;
        }
    }

    @Override
    public void deleteUserById(UUID id) {
        try {
            m_userEntityRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException(DELETE_ERROR_MESSAGE);
        }
    }

    @Override
    public void deleteUserByUserName(String username) {
        try {
            m_userEntityRepository.deleteByUserName(username);
        } catch (Exception e) {
            throw new RuntimeException(DELETE_ERROR_MESSAGE);
        }
    }

}
