package com.alkemy.ong.security.service;

import com.alkemy.ong.security.dto.UserGetDto;
import com.alkemy.ong.security.dto.UserPostDto;

import java.io.IOException;

public interface IUserService {
    UserGetDto registerUser(UserPostDto dto) throws IOException;
}
