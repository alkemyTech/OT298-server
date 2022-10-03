package com.alkemy.ong.service;

import com.alkemy.ong.dto.NewsDto;
import com.alkemy.ong.model.News;

import java.util.Optional;
import java.util.List;

public interface INewsService {
    NewsDto save(NewsDto dto);
    NewsDto update(Long id,NewsDto dto);
    void deleteById(Long id);
    boolean existsById(Long id);
    Optional<News> findById(Long id);
    Optional<List> findAll();
    NewsDto getById(Long id);
}
