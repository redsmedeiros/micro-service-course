package com.rodolpho.service;

import com.rodolpho.payload.LoginDto;

public interface AuthService {
    
    String login(LoginDto loginDto);
}
