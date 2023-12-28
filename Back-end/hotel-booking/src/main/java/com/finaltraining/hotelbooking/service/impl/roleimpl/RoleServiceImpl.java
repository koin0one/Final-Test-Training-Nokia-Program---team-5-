package com.finaltraining.hotelbooking.service.impl.roleimpl;

import com.finaltraining.hotelbooking.convert.ConvertRole;
import com.finaltraining.hotelbooking.dto.RoleEntityDto;
import com.finaltraining.hotelbooking.entity.RoleEntity;
import com.finaltraining.hotelbooking.repository.RoleEntityRepository;
import com.finaltraining.hotelbooking.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleEntityRepository m_roleEntityRepository;
    @Autowired
    private ConvertRole m_convertRole;
    @Override
    public void addRole(RoleEntityDto roleEntityDto) {
        RoleEntity roleEntity = m_convertRole.convertToDatabaseColumn(roleEntityDto);
        m_roleEntityRepository.save(roleEntity);
    }

    @Override
    public List<RoleEntityDto> findAllRole() {
        List<RoleEntityDto> roleEntityDtos = new ArrayList<>();
        List<RoleEntity> roleEntities = m_roleEntityRepository.findAll();
        for (RoleEntity roleEntity : roleEntities) {
            RoleEntityDto roleEntityDto = m_convertRole.convertToEntityAttribute(roleEntity);
            roleEntityDtos.add(roleEntityDto);
        }
        return roleEntityDtos;
    }

    @Override
    public RoleEntityDto findRoleById(UUID id) {
        RoleEntity roleEntity = m_roleEntityRepository.findById(id);
        if (roleEntity != null){
            return m_convertRole.convertToEntityAttribute(roleEntity);
        } else {
            return null;
        }
    }

    @Override
    public void deleteRoleById(UUID id) {

    }
}
