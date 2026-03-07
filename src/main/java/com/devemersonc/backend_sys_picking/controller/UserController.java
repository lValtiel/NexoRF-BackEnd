package com.devemersonc.backend_sys_picking.controller;

import com.devemersonc.backend_sys_picking.DTO.*;
import com.devemersonc.backend_sys_picking.service.user.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getUsers() {
        List<UserResponseDTO> usersDTO = userService.getUsers();
        return ResponseEntity.ok(usersDTO);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<UserResponseDTO> getUser(@PathVariable Long user_id) {
        UserResponseDTO userResponseDTO = userService.getUser(user_id);
        return ResponseEntity.ok(userResponseDTO);
    }

    @PostMapping
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserRegisterRequest request) {
        userService.registerUser(request.getUser(), request.getRole());
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado con éxito.");
    }

    @PutMapping("/{user_id}")
    public ResponseEntity<String> updateUser(@Valid @RequestBody UserUpdateDTO userUpdateDTO, @PathVariable Long user_id) {
        userService.updateUser(user_id, userUpdateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario actualizado con éxito.");
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long user_id) {
        userService.deleteUser(user_id);
        return ResponseEntity.ok("Usuario eliminado con éxito.");
    }
}