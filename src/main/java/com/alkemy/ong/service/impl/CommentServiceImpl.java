package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.CommentBasicDTO;
import com.alkemy.ong.dto.CommentDto;
import com.alkemy.ong.exception.EntityNotSavedException;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.exception.UnauthorizedException;
import com.alkemy.ong.mapper.CommentMapper;
import com.alkemy.ong.model.Comment;
import com.alkemy.ong.repository.CommentRepository;
import com.alkemy.ong.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import static com.alkemy.ong.util.Constants.ROLE_ADMIN;

@Service
@Transactional
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private MessageSource message;

    @Override
    public CommentDto save(CommentDto commentDto) {
        try {
            Comment commentEntity = commentMapper.commentDtoToEntity(commentDto);
            Comment savedEntity = commentRepository.save(commentEntity);
            return commentMapper.commentEntityToDto(savedEntity);
        } catch (EntityNotSavedException ense) {
            throw new EntityNotSavedException(message.getMessage("comment.notAdded", null, Locale.US));
        }
    }

    @Override
    public List<CommentBasicDTO> getAllComments() {
        List<Comment> comments = commentRepository.getAllByOrderByCreationDateDesc();
        if (!comments.isEmpty()){
            List<CommentBasicDTO> dtoList = new ArrayList<>();
            for(Comment comment : comments){
                dtoList.add(commentMapper.commentBodyToCommentBasicDTO(comment));
            }
            return dtoList;
        } else {
            throw new ResourceNotFoundException(message.getMessage("comments.notFound", null, Locale.US));
        }
    }

    @Override
    public CommentDto updateComment(Long commentId, CommentBasicDTO dto) {
        if (!commentRepository.existsById(commentId)){
            throw new ResourceNotFoundException(message.getMessage("comment.notFound", null, Locale.US));
        }
        if (dto.getBody() == null){
            throw new ResourceNotFoundException(message.getMessage("request.body", null, Locale.US));
        }
        Comment comment = commentRepository.getById(commentId);
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        if (comment.getUser().getUsername().equals(auth.getName()) || auth.getAuthorities().stream()
                .anyMatch(a -> a.getAuthority().equals(ROLE_ADMIN))){
            Comment updatedComment = commentMapper.updateCommentBody(dto, comment);
            Comment savedComment = commentRepository.save(updatedComment);
            return commentMapper.commentEntityToDto(savedComment);
        }else{
            throw new UnauthorizedException(message.getMessage("unauthorized.comment", null, Locale.US));
        }
    }
}
