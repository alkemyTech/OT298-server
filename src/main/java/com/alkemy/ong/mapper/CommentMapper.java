package com.alkemy.ong.mapper;


import com.alkemy.ong.dto.CommentDto;

import com.alkemy.ong.model.Comment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CommentMapper {

    CommentDto commentEntityToDto (Comment comment);

    Comment commentDtoToEntity(CommentDto commentDto);


}
