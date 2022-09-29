package com.alkemy.ong.service.impl;


import com.alkemy.ong.dto.CategoryGetDto;
import com.alkemy.ong.exception.ThereAreNoCategories;
import com.alkemy.ong.dto.CategoryDTO;

import com.alkemy.ong.mapper.CategoryMapper;
import com.alkemy.ong.model.Category;
import com.alkemy.ong.repository.CategoryRepository;
import com.alkemy.ong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

import javax.transaction.Transactional;


@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryMapper categoryMapper;

    @Autowired
    private MessageSource message;

    @Override
    public List<CategoryGetDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
        if(categories.isEmpty()){
            throw new ThereAreNoCategories(message.getMessage("category.thereAreNo", null, Locale.US));
        }
        List<CategoryGetDto> listDtosCategories = categoryMapper.listCategoriesToListDtos(categories);
        return listDtosCategories;
    }

    @Transactional
    @Override
    public CategoryDTO save (CategoryDTO dto){
            Category category = categoryMapper.categoryDTOToCategory(dto);
            Category savedCategory = categoryRepository.save(category);
            return categoryMapper.categoryToCategoryDTO(savedCategory);
    }
}
