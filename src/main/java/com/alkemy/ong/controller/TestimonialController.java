package com.alkemy.ong.controller;

import com.alkemy.ong.dto.TestimonialDTO;
import com.alkemy.ong.service.ITestimonialService;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/testimonials")
public class TestimonialController {
    
    @Autowired
    private ITestimonialService service;
    
    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody TestimonialDTO dto) throws Exception{
        return new ResponseEntity<>(service.save(dto), HttpStatus.OK);
    }
}