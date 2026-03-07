package com.devemersonc.backend_sys_picking.service.authService;

import com.devemersonc.backend_sys_picking.DTO.authDTO.AuthRequest;
import com.devemersonc.backend_sys_picking.DTO.authDTO.AuthResponse;

public interface AuthService {
    AuthResponse login(AuthRequest authRequest);
}
