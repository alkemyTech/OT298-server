package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.CategoryGetDto;
import com.alkemy.ong.mapper.CategoryMapper;
import com.alkemy.ong.model.Category;
import com.alkemy.ong.repository.CategoryRepository;
import com.alkemy.ong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<CategoryGetDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryGetDto> listDtosCategories = categoryMapper.listCategoriesToListDtos(categories);
        return listDtosCategories;
    }
}
