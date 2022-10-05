package com.alkemy.ong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.alkemy.ong.util.Constants.Endpoints;

import com.alkemy.ong.service.ISlidesService;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.dto.SlidesDTO;

@RestController
@RequestMapping(Endpoints.SLIDE)
public class SlidesController {
    @Autowired
    private ISlidesService slidesService;

    @PostMapping
    public ResponseEntity<SlidesDTO> save(@RequestBody SlidesDTO slidesDTO) {

        SlidesDTO slidesSave = slidesService.save(slidesDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(slidesSave);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws ResourceNotFoundException {
        return new ResponseEntity<>(slidesService.delete(id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SlidesDTO> getSlidesById(@PathVariable Long id) {
        SlidesDTO dto = slidesService.getById(id);
        return ResponseEntity.ok(dto);
    }
}

