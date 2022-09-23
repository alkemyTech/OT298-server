package com.alkemy.ong.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;

import com.alkemy.ong.repository.NewsRepository;
import com.alkemy.ong.service.INewsService;
import com.alkemy.ong.mapper.NewsMapper;
import com.alkemy.ong.model.News;
import com.alkemy.ong.dto.NewsDto;

@Service
@Transactional
public class NewsServiceImpl implements INewsService {
    @Autowired
    private NewsRepository repo;

    @Autowired
    private NewsMapper mapper;

    public NewsDto save(NewsDto dto){
        News news = repo.save(mapper.toEntity(dto));
        return mapper.toDto(news);
    }
    public void deleteById(Long id){
        repo.deleteById(id);
    }
    public boolean existById(Long id){
        return repo.existById(id);
    }
    public Optional<News> findById(Long id){
        return repo.findById(id);
    }
    public Optional<List> findAll(){
        return repo.findAll();
    }
}