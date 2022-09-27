package com.alkemy.ong.security.controller;

import com.alkemy.ong.security.dto.UserGetDto;
import com.alkemy.ong.security.dto.UserPostDto;
import com.alkemy.ong.security.service.IUserService;
import org.springframework.http.HttpStatus;
import com.alkemy.ong.security.dto.AuthRequest;
import com.alkemy.ong.security.dto.AuthResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/auth")
public class UserController {
    @Autowired
    private IUserService userService;


    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody UserPostDto dto){
        AuthResponse response = userService.registerUser(dto);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> signIn(@Valid @RequestBody AuthRequest request) throws Exception {
        AuthResponse response = userService.authenticate(request);

        return ResponseEntity.ok(response);

    }

}
