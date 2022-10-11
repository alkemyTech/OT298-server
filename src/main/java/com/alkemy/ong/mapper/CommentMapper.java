package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.CommentBasicDTO;
import com.alkemy.ong.dto.CommentDto;
import com.alkemy.ong.exception.ResourceNotFoundException;
import com.alkemy.ong.model.Comment;
import com.alkemy.ong.model.News;
import com.alkemy.ong.repository.NewsRepository;
import com.alkemy.ong.security.model.User;
import com.alkemy.ong.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class CommentMapper {


    @Autowired
    private UserRepository usersRepository;
    @Autowired
    private NewsRepository newsRepository;

    @Autowired
    private MessageSource message;

    public CommentDto commentEntityToDto(Comment comment) {

        CommentDto commentDto = new CommentDto();


        commentDto.setId( comment.getId() );
        commentDto.setBody( comment.getBody() );
        commentDto.setUserId(comment.getUser().getId());
        commentDto.setNewsId(comment.getNews().getId() );
        commentDto.setCreationDate( comment.getCreationDate() );
        commentDto.setUpdateDate( comment.getUpdateDate() );

        return commentDto;
    }

    public Comment commentDtoToEntity(CommentDto commentDto) {
      
        User user = usersRepository.findById(commentDto.getUserId()).orElseThrow(() -> new UsernameNotFoundException(message.getMessage("user.notFound",null, Locale.US)));

        News news = newsRepository.findById(commentDto.getNewsId()).orElseThrow(()-> new UsernameNotFoundException(message.getMessage("news.notFound",null, Locale.US)));

        Comment comment = new Comment();

        comment.setBody( commentDto.getBody() );
        comment.setUser( user );

        comment.setNews( news );
        news.getComments().add(comment);

        comment.setCreationDate( commentDto.getCreationDate() );
        comment.setUpdateDate( commentDto.getUpdateDate() );

        return comment;
    }

    public CommentBasicDTO commentBodyToCommentBasicDTO(Comment comment){
        CommentBasicDTO dto = new CommentBasicDTO();
        dto.setBody(comment.getBody());
        return dto;
    }

    public List<CommentBasicDTO> listCommentsToListDtos(List<Comment> comments){
        List<CommentBasicDTO> commentsDtos =
                comments.stream().map(comment -> commentBodyToCommentBasicDTO(comment)).collect(Collectors.toList());
        return commentsDtos;
    }

    public Comment updateCommentDtoToComment (String body, Comment comment){
        if (body != null){
            comment.setBody(body);
            return comment;
        }
        return null;
    }
}
