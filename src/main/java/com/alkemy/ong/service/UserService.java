package com.alkemy.ong.service;

import com.alkemy.ong.dto.UserGetDto;
import com.alkemy.ong.dto.UserPostDto;

public interface UserService {

    UserGetDto registerUser(UserPostDto dto);

}
