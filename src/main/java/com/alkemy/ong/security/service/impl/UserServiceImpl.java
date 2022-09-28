package com.alkemy.ong.security.service.impl;


import com.alkemy.ong.security.model.Role;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import com.alkemy.ong.exception.AlreadyExistsException;
import com.alkemy.ong.exception.ParameterNotFound;
import com.alkemy.ong.security.dto.AuthRequest;
import com.alkemy.ong.security.dto.AuthResponse;
import com.alkemy.ong.security.model.User;
import com.alkemy.ong.security.repository.UserRepository;
import com.alkemy.ong.security.service.IUserService;
import com.alkemy.ong.security.service.JwtUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import com.alkemy.ong.security.dto.UserGetDto;
import com.alkemy.ong.security.dto.UserPostDto;
import com.alkemy.ong.security.mapper.UserMapper;

import com.alkemy.ong.security.repository.RoleRepository;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Collections;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;



    @Autowired
    private MessageSource message;


    public AuthResponse authenticate(AuthRequest request) throws ParameterNotFound {

        User user = userRepository.findByEmail(request.getUsername());

        if (  user==null) {
            throw new UsernameNotFoundException("Username not found");
         }


             UserDetails userDetails;

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );
            userDetails = (UserDetails) auth.getPrincipal();
        } catch (BadCredentialsException e) {
            throw new ParameterNotFound(message.getMessage("credencials.incorrect",null,Locale.US));
        }
        final String jwt = jwtUtils.generateToken(userDetails);
        return new AuthResponse(jwt);
    }




    @Override
    public UserGetDto registerUser(UserPostDto dto) {

        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new AlreadyExistsException(
                    "There is an account with that email address:" + dto.getEmail());
        }

        User user = userMapper.userPostDtoToUser(dto);
        user.setPassword(passwordEncoder.encode(dto.getPassword()));

        user.setRole(roleRepository.findByName(dto.getNameRole()).get());

        User savedUser = userRepository.save(user);

        UserGetDto userGetDto = userMapper.userToUserDto(savedUser);
      //  userGetDto.setNameRole(savedUser.getRoles().getName());

        return userGetDto;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        if(user==null){

            throw new UsernameNotFoundException(message.getMessage("email.notfound",null,Locale.US));
        }
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + user.getRoles());

        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Collections.singletonList(authority));
    }
 }
 

