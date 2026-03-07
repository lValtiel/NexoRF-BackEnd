package com.devemersonc.backend_sys_picking.mapper;

import com.devemersonc.backend_sys_picking.DTO.UserCreateDTO;
import com.devemersonc.backend_sys_picking.DTO.UserResponseDTO;
import com.devemersonc.backend_sys_picking.DTO.UserUpdateDTO;
import com.devemersonc.backend_sys_picking.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", source = "id")
    List<UserResponseDTO> toDTOList(List<User> users);
    UserResponseDTO toDTO(User user);
}