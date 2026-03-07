package com.devemersonc.backend_sys_picking.DTO;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleRequest {
    @NotBlank(message = "El rol del usuario es obligatorio.")
    private String name;
}