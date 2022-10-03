package com.alkemy.ong.service.impl;

import com.alkemy.ong.exception.ResourceNotFoundException;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

import com.alkemy.ong.repository.NewsRepository;
import com.alkemy.ong.service.INewsService;
import com.alkemy.ong.mapper.NewsMapper;
import com.alkemy.ong.model.News;
import com.alkemy.ong.dto.NewsDto;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
@Transactional
public class NewsServiceImpl implements INewsService {
    @Autowired
    private NewsRepository repo;

    @Autowired
    private NewsMapper mapper;

    @Autowired
    private MessageSource message;

    public NewsDto save(NewsDto dto){
        News news = repo.save(mapper.toEntity(dto));
        return mapper.toDto(news);
    }

    @Override
    public NewsDto update(Long id, NewsDto dto) {
        if(!repo.existsById(id)){
            throw new ResourceNotFoundException(message.getMessage("new.notFound", null, Locale.US));
        }
        News newsEntity = repo.findById(id).get();
        News news = repo.save(mapper.updateNewsFromDto(dto, newsEntity));
        NewsDto newsDto = mapper.toDto(news);
        return newsDto;
    }

    public void deleteById(Long id){
        repo.deleteById(id);
    }
    public boolean existsById(Long id){
        return repo.existsById(id);
    }
    public Optional<News> findById(Long id){
        return repo.findById(id);
    }
    public Optional<List> findAll(){
        return Optional.of(repo.findAll());
    }
}