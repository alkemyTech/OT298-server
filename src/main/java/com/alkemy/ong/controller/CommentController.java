package com.alkemy.ong.controller;

import com.alkemy.ong.dto.CommentDto;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.service.ICommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("comments")
public class CommentController {

    private ICommentService commentService;

    @PostMapping
    ResponseEntity<CommentDto> newComment(@Valid @RequestBody CommentDto commentDto) throws ResourceNotFoundException {

        CommentDto commentDtoSaved = commentService.save(commentDto);

        return  ResponseEntity.status(HttpStatus.CREATED).body(commentDtoSaved);
    }
}
