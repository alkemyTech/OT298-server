package com.alkemy.ong.controller;

import com.alkemy.ong.dto.CommentBasicDTO;
import com.alkemy.ong.dto.CommentDto;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("comments")
public class CommentController {

    @Autowired
    private ICommentService commentService;

    @PostMapping
    public ResponseEntity<CommentDto> newComment(@Valid @RequestBody CommentDto commentDto) throws ResourceNotFoundException {
        CommentDto commentDtoSaved = commentService.save(commentDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(commentDtoSaved);
    }

    @GetMapping
    public ResponseEntity<List<CommentBasicDTO>> getAllComments (){
        List<CommentBasicDTO> comments = commentService.getAllComments();
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(comments);
    }
}
