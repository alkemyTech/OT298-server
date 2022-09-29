package com.alkemy.ong.controller;

import com.alkemy.ong.security.dto.UserGetDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alkemy.ong.security.service.IUserService;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<?> getAll() throws Exception {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
}