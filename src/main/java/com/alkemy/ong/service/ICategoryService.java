package com.alkemy.ong.service;


import com.alkemy.ong.dto.CategoryCompleteGetDto;
import com.alkemy.ong.dto.CategoryGetDto;
import com.alkemy.ong.dto.CategoryDTO;
import com.alkemy.ong.model.Category;

import java.util.List;

import javax.transaction.Transactional;

public interface ICategoryService {

    @Transactional
    CategoryDTO save(CategoryDTO dto);

    List<CategoryGetDto> getAllCategories();

    CategoryCompleteGetDto getCategoryById(Long id);
}
