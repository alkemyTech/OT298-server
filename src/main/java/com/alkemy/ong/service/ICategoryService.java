package com.alkemy.ong.service;

import com.alkemy.ong.dto.CategoryDTO;

import javax.transaction.Transactional;

public interface ICategoryService {

    @Transactional
    CategoryDTO save(CategoryDTO dto);
}
