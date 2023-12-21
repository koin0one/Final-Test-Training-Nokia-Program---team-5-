package com.finaltraining.hotelbooking.service.impl.userimpl;

import com.finaltraining.hotelbooking.convert.ConvertUser;
import com.finaltraining.hotelbooking.dto.UserEntityDto;
import com.finaltraining.hotelbooking.entity.UserEntity;
import com.finaltraining.hotelbooking.repository.RoleEntityRepository;
import com.finaltraining.hotelbooking.repository.UserEntityRepository;
import com.finaltraining.hotelbooking.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserEntityRepository m_userUserEntityRepository;

    @Autowired
    private RoleEntityRepository m_rolRoleEntityRepository;

    @Autowired
    private ConvertUser m_converUser;

    @Override
    public void AddUser(UserEntityDto user) {
        UserEntity userEntity = m_converUser.convertToDatabaseColumn(user);
        m_userUserEntityRepository.save(userEntity);
    }

    @Override
    public List<UserEntityDto> findAllUser() {
        List<UserEntityDto> listUserDto = new ArrayList<>();
        List<UserEntity> listUserEntity = m_userUserEntityRepository.findAll();
        for (UserEntity userEntity : listUserEntity){
            if (userEntity != null){
                listUserDto.add(m_converUser.convertToEntityAttribute(userEntity));
            }
        }
        return listUserDto;
    }

    @Override
    public UserEntityDto findUserById(UUID id) {
        UserEntity userEntity = m_userUserEntityRepository.findById(id);
        UserEntityDto userEntityDto = m_converUser.convertToEntityAttribute(userEntity);
        return userEntityDto;
    }

    @Override
    public UserEntityDto findUserByUserName(String userName) {
        UserEntity userEntity = m_userUserEntityRepository.findByUserName(userName);
        UserEntityDto userEntityDto = m_converUser.convertToEntityAttribute(userEntity);
        return userEntityDto;
    }
}
