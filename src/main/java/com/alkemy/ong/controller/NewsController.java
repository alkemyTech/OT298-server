package com.alkemy.ong.controller;

import com.alkemy.ong.dto.NewsDto;
import com.alkemy.ong.service.INewsService;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @PostMapping
    public ResponseEntity<?> saveNews(@Valid NewsDto newsDto) throws Exception{
        return new ResponseEntity<>(newsService.save(newsDto), HttpStatus.OK);
    }

    @RolesAllowed("ADMIN")
    @GetMapping("/{id}")
    public ResponseEntity<NewsDto> getById(@PathVariable Long id){
        NewsDto newsDto = newsService.getById(id);
        return ResponseEntity.ok().body(newsDto);
    }
}
