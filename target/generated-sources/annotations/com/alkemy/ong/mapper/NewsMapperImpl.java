package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.NewsDto;
import com.alkemy.ong.model.News;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-05T11:49:18-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Ubuntu)"
)
@Component
public class NewsMapperImpl implements NewsMapper {

    @Override
    public NewsDto toDto(News news) {
        if ( news == null ) {
            return null;
        }

        NewsDto newsDto = new NewsDto();

        newsDto.setName( news.getName() );
        newsDto.setContent( news.getContent() );
        newsDto.setImage( news.getImage() );
        newsDto.setCategoryId( news.getCategoryId() );

        return newsDto;
    }

    @Override
    public News toEntity(NewsDto newsDto) {
        if ( newsDto == null ) {
            return null;
        }

        News news = new News();

        news.setName( newsDto.getName() );
        news.setContent( newsDto.getContent() );
        news.setImage( newsDto.getImage() );
        news.setCategoryId( newsDto.getCategoryId() );

        return news;
    }

    @Override
    public News updateNewsFromDto(NewsDto dto, News news) {
        if ( dto == null ) {
            return null;
        }

        news.setName( dto.getName() );
        news.setContent( dto.getContent() );
        news.setImage( dto.getImage() );
        news.setCategoryId( dto.getCategoryId() );

        return news;
    }
}
