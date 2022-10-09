package com.alkemy.ong.controller;

import com.alkemy.ong.dto.CommentDto;
import com.alkemy.ong.dto.NewsDto;
import com.alkemy.ong.service.INewsService;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    private INewsService newsService;

    @PostMapping
    public ResponseEntity<?> saveNews(@Valid @RequestBody NewsDto newsDto) throws Exception{
        return new ResponseEntity<>(newsService.save(newsDto), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDto> getById(@PathVariable Long id){
        NewsDto newsDto = newsService.getById(id);
        return ResponseEntity.ok().body(newsDto);
    }

    @GetMapping("/{id}/comments")
    public ResponseEntity<List<CommentDto>> getCommentsByNew(@PathVariable Long id){
        List<CommentDto> comments = newsService.getAllCommentsByNewsId(id);
        return new ResponseEntity<List<CommentDto>>(comments, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsDto> updateNews(@PathVariable Long id, @Valid @RequestBody NewsDto newsDto){
        NewsDto news = newsService.update(id, newsDto);
        return new ResponseEntity<NewsDto>(news, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNews(@PathVariable Long id){
        newsService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
