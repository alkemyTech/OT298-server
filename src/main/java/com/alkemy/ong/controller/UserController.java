package com.alkemy.ong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static com.alkemy.ong.util.Constants.Endpoints;
import com.alkemy.ong.security.service.IUserService;
import com.alkemy.ong.security.dto.UserPostDto;
import com.alkemy.ong.exception.ResourceNotFoundException;

@RestController
@RequestMapping(Endpoints.USER)
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<?> getAll() throws Exception {
        return new ResponseEntity<>(userService.getAllAuxUsers(), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody UserPostDto dto) throws ResourceNotFoundException {
            return new ResponseEntity<>(userService.update(id, dto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(userService.deleteUser(id), HttpStatus.NO_CONTENT);
    }
}
