package com.alkemy.ong.security.service.impl;

import com.alkemy.ong.exception.*;
import com.alkemy.ong.dto.AuxUserGetDto;
import com.alkemy.ong.security.dto.UserGetDto;
import org.springframework.security.core.context.SecurityContextHolder;
import com.alkemy.ong.exception.AlreadyExistsException;
import com.alkemy.ong.exception.ParameterNotFound;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.security.service.*;
import com.alkemy.ong.security.model.*;
import com.alkemy.ong.security.repository.UserRepository;
import com.alkemy.ong.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.alkemy.ong.security.dto.UserPostDto;
import com.alkemy.ong.security.mapper.UserMapper;

import static com.alkemy.ong.util.Constants.ROLE_ADMIN;
import static com.alkemy.ong.util.Constants.ROLE_USER;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private MessageSource message;

    @Override
    public List<UserGetDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserGetDto> usersDtos = userMapper.listUsersToListDtos(users);
        return usersDtos;
    }

    @Override
    public List<AuxUserGetDto> getAllAuxUsers() {
        List<User> users = userRepository.findAll();
        List<AuxUserGetDto> usersDtos = userMapper.toAuxList(users);
        return usersDtos;
    }

    @Override
    @Transactional
    public UserGetDto saveTestDataUser(UserPostDto dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new AlreadyExistsException(
                    message.getMessage("email.exists", null, Locale.US));
        }

        User user = userMapper.userPostDtoToUser(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        User savedUser = userRepository.save(user);

        UserGetDto userGetDto = userMapper.userToUserDto(savedUser);

        List<User> users = userRepository.findAll();
        for (User userGet : users) {
            if (userGet.getId() >= 1 && userGet.getId() <= 10) {
                this.addRoleToUser(ROLE_ADMIN, user);
            } else {
                this.addRoleToUser(ROLE_USER, user);
            }
        }

        return userGetDto;
    }

    @Override
    @Transactional
    public AuxUserGetDto deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent()) {
            throw new ParameterNotFound(message.getMessage("id.invalid", null, Locale.US));
        }
        String target = user.get().getEmail();
        String logged = SecurityContextHolder.getContext().getAuthentication().getName();
        if (!logged.equals(target)) {
            throw new MismatchException(message.getMessage("mismatch.users", null, Locale.US));
        }
        userRepository.deleteById(id);
        return userMapper.toAuxDto(user.get());
    }

    @Override
    @Transactional
    public void addRoleToUser(String nameRole, User user) {
        Role role = roleRepository.findByName(nameRole);
        Set<Role> roles = new HashSet<>();
        roles.add(role);
        user.setRoles(roles);

        role.getUsers().add(user);
    }

    @Override
    public AuxUserGetDto update(Long id, UserPostDto dto) throws ResourceNotFoundException {
        if (!userRepository.existsById(id)) {
            throw new ResourceNotFoundException(message.getMessage("id.invalid", null, Locale.US));
        }
        User user = userRepository.findById(id).get();

        if (dto.getFirstName() != null) {
            user.setFirstName(dto.getFirstName());
        }

        if (dto.getLastName() != null) {
            user.setLastName(dto.getLastName());
        }

        if (dto.getPhoto() != null) {
            user.setPhoto(dto.getPhoto());
        }

        if (dto.getPassword() != null) {
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        return userMapper.toAuxDto(userRepository.save(user));
    }
}
