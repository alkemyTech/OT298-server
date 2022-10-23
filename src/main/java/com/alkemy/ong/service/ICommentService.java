package com.alkemy.ong.service;

import com.alkemy.ong.dto.CommentBasicDTO;
import com.alkemy.ong.dto.CommentDto;

import org.springframework.security.core.Authentication;


import java.util.List;

public interface ICommentService {

    CommentBasicDTO save(CommentDto commentDto, Authentication authentication);

    List<CommentBasicDTO> getAllComments();


    void delete(Long id, Authentication authentication) ;

    CommentDto updateComment(Long id, CommentBasicDTO dto);

}
