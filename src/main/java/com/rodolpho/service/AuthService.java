package com.rodolpho.service;

import com.rodolpho.payload.LoginDto;
import com.rodolpho.payload.RegisterDto;

public interface AuthService {
    
    String login(LoginDto loginDto);

    String register(RegisterDto registerDto);
}
