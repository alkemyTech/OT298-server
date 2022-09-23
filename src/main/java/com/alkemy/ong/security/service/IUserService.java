package com.alkemy.ong.security.service;

import com.alkemy.ong.exception.ParameterNotFound;
import com.alkemy.ong.security.dto.AuthRequest;
import com.alkemy.ong.security.dto.AuthResponse;

public interface IUserService {



    AuthResponse authenticate(AuthRequest request) throws ParameterNotFound;
}
