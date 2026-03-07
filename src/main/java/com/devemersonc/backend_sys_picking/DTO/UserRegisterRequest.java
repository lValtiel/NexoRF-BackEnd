package com.devemersonc.backend_sys_picking.DTO;

import jakarta.validation.Valid;

public class UserRegisterRequest {
    @Valid
    private UserCreateDTO user;
    @Valid
    private RoleRequest role;

    public UserCreateDTO getUser() {
        return user;
    }

    public void setUser(UserCreateDTO user) {
        this.user = user;
    }

    public RoleRequest getRole() {
        return role;
    }

    public void setRole(RoleRequest role) {
        this.role = role;
    }
}
