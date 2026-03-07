package com.devemersonc.backend_sys_picking.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserResponseDTO {
    private Long id;
    private String username;
    private String name;
    private String lastName;
    private String email;
    private String rut;
}
