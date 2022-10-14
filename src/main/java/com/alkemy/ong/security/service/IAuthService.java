package com.alkemy.ong.security.service;

import com.alkemy.ong.exception.ParameterNotFound;
import com.alkemy.ong.security.dto.AuthRequest;
import com.alkemy.ong.security.dto.AuthResponse;
import com.alkemy.ong.security.dto.UserGetDto;
import com.alkemy.ong.security.dto.UserInformationDto;
import com.alkemy.ong.security.dto.UserPostDto;
import java.io.IOException;
import org.springframework.security.core.Authentication;

public interface IAuthService {

    AuthResponse authenticate(AuthRequest request) throws ParameterNotFound;

    UserGetDto registerUser(UserPostDto dto) throws IOException;

    UserInformationDto getCurrentAuthenticatedUser(Authentication authentication);

}
