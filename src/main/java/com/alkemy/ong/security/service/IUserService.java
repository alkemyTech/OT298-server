package com.alkemy.ong.security.service;

import com.alkemy.ong.dto.AuxUserGetDto;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.security.dto.*;
import com.alkemy.ong.security.model.User;
import java.util.List;

public interface IUserService {

    void addRoleToUser(String nameRole, User user);

    UserGetDto saveTestDataUser(UserPostDto dto);

    List<UserGetDto> getAllUsers();

    List<AuxUserGetDto> getAllAuxUsers();

    AuxUserGetDto update(Long id, UserPostDto dto) throws ResourceNotFoundException;

    AuxUserGetDto deleteUser(Long id);

}
