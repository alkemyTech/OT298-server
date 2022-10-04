package com.alkemy.ong.controller;

import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.service.ISlidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("slides")
public class SlidesController {

    @Autowired
    ISlidesService slidesService;

    @PostMapping
    public ResponseEntity<SlidesDTO> save(@RequestBody SlidesDTO slidesDTO){

        SlidesDTO slidesSave = slidesService.save(slidesDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(slidesSave);

    }

}
