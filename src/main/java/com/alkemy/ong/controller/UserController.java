package com.alkemy.ong.controller;

import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.security.dto.UserPostDto;
import com.alkemy.ong.security.service.IUserService;
import static com.alkemy.ong.util.Constants.Endpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Endpoints.USER)
public class UserController {

    @Autowired
    private IUserService userService;

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserPostDto dto) throws ResourceNotFoundException {
            return new ResponseEntity<>(userService.update(id, dto), HttpStatus.OK);
    }
}
