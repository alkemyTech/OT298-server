package com.alkemy.ong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
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
    public ResponseEntity<SlidesDTO> save(@RequestBody SlidesDTO slidesDTO){

        SlidesDTO slidesSave = slidesService.save(slidesDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(slidesSave);

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) throws ResourceNotFoundException{
        return new ResponseEntity<>(slidesService.delete(id), HttpStatus.ACCEPTED);
    }
}

