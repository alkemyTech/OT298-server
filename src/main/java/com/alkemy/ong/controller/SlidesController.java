package com.alkemy.ong.controller;

import com.alkemy.ong.dto.SlidesDTO;
import com.alkemy.ong.service.ISlidesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static com.alkemy.ong.util.Constants.Endpoints;
import com.alkemy.ong.service.ISlidesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.alkemy.ong.exception.ResourceNotFoundException;
import java.util.List;

@RestController
@RequestMapping(Endpoints.SLIDE)
public class SlidesController {
    @Autowired
    private ISlidesService slidesService;

    @GetMapping
    public ResponseEntity<List<SlidesDTO>> getAllSlides() {
        return ResponseEntity.status(HttpStatus.OK).body(slidesService.getAllSlides());
    }

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