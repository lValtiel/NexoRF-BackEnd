package com.devemersonc.backend_sys_picking.controller;

import com.devemersonc.backend_sys_picking.DTO.authDTO.AuthRequest;
import com.devemersonc.backend_sys_picking.DTO.authDTO.AuthResponse;
import com.devemersonc.backend_sys_picking.service.authService.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) {
        return authService.login(authRequest);
    }
}
