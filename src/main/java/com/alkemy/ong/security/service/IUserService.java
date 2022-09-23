package com.alkemy.ong.security.service;

import com.alkemy.ong.security.dto.UserGetDto;
import com.alkemy.ong.security.dto.UserPostDto;

public interface IUserService {
    UserGetDto registerUser(UserPostDto dto);
}
