package com.devemersonc.backend_sys_picking.service.user;

import com.devemersonc.backend_sys_picking.DTO.RoleRequest;
import com.devemersonc.backend_sys_picking.DTO.UserCreateDTO;
import com.devemersonc.backend_sys_picking.DTO.UserResponseDTO;
import com.devemersonc.backend_sys_picking.DTO.UserUpdateDTO;
import com.devemersonc.backend_sys_picking.model.User;

import java.util.List;

public interface UserService {
    List<UserResponseDTO> getUsers();
    UserResponseDTO getUser(Long user_id);
    void registerUser(UserCreateDTO userCreateDTO, RoleRequest roleRequest);
    void updateUser(Long user_id, UserUpdateDTO userUpdateDTO);
    void deleteUser(Long user_id);
    User findById(Long user_id);
}
