package com.alkemy.ong.service;

import com.alkemy.ong.dto.CommentBasicDTO;
import com.alkemy.ong.dto.CommentDto;

import java.util.List;

public interface ICommentService {

    CommentDto save(CommentDto commentDto);

    List<CommentBasicDTO> getAllComments();

    CommentDto updateComment(Long id, CommentBasicDTO dto);
}
