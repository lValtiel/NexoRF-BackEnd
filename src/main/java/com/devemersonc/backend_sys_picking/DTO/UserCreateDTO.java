package com.devemersonc.backend_sys_picking.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {
    @NotBlank(message = "El nombre de usuario es obligatorio.")
    private String username;
    @NotBlank(message = "El nombre es obligatorio.")
    private String name;
    @NotBlank(message = "El apellido es obligatorio.")
    private String lastName;
    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
    @NotBlank(message = "El email es obligatorio.")
    @Email(message = "Ingresa un email válido.")
    private String email;
    @NotBlank(message = "El rut es obligatorio.")
    private String rut;
}
