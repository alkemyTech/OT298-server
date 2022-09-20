package com.alkemy.ong.controller;

import com.alkemy.ong.dto.UserGetDto;
import com.alkemy.ong.dto.UserPostDto;
import com.alkemy.ong.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/auth/register")
    public ResponseEntity<UserGetDto> register(@Valid @RequestBody UserPostDto dto){
        UserGetDto userGetDto = userService.registerUser(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(userGetDto);
    }
}
