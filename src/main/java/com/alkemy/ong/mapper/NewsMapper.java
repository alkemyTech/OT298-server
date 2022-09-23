package com.alkemy.ong.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.alkemy.ong.model.News;
import com.alkemy.ong.dto.NewsDto;

@Mapper(componentModel = "spring")
public interface NewsMapper {
    NewsDto toDto(News news);
    News toEntity(NewsDto newsDto);
}