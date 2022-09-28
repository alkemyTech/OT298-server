package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.CommentDto;
import com.alkemy.ong.exception.ParameterNotFound;
import com.alkemy.ong.mapper.CommentMapper;
import com.alkemy.ong.model.Comment;
import com.alkemy.ong.repository.CommentRepository;
import com.alkemy.ong.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import org.springframework.stereotype.Service;


import java.util.Locale;

@Service
public class CommentServiceImpl implements ICommentService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private MessageSource messageSource;


    @Override
    public CommentDto save(CommentDto commentDto) {


        try {
            Comment commentEntity = commentMapper.commentDtoToEntity(commentDto);

            if(commentEntity==null) {
                throw new NullPointerException(messageSource.getMessage("null.dto", null, Locale.US));
            }

            try {
                Comment savedEntity=commentRepository.save(commentEntity);



                return   commentMapper.commentEntityToDto(savedEntity);
            }
            catch (ParameterNotFound pnf){

                throw new ParameterNotFound(messageSource.getMessage("not.saved.entity",null,Locale.US));
            }



        } catch (ParameterNotFound pnf) {

            throw new ParameterNotFound(messageSource.getMessage("mapper.error",null,Locale.US));
        }




    }
}
