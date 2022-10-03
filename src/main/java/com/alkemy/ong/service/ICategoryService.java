package com.alkemy.ong.service;


import com.alkemy.ong.dto.CategoryCompleteGetDto;
import com.alkemy.ong.dto.CategoryGetDto;
import com.alkemy.ong.dto.CategoryDTO;

import java.util.List;

import javax.transaction.Transactional;

public interface ICategoryService {

    @Transactional
    CategoryDTO save(CategoryDTO dto);
    
    List<CategoryGetDto> getAllCategories();

    void delete(Long id);

    CategoryDTO update(Long id, CategoryDTO dto);

    CategoryCompleteGetDto getCategoryById(Long id);
}
