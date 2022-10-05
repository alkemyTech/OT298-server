package com.alkemy.ong.controller;

import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.service.ISlidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/slides")
public class SlidesController {

    @Autowired
    private ISlidesService slidesService;

    @GetMapping
    public ResponseEntity<List<SlidesDTO>> getAllSlides(){
        return ResponseEntity.status(HttpStatus.OK).body(slidesService.getAllSlides());
    }
}
