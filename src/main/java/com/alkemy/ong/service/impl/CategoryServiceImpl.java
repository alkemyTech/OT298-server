package com.alkemy.ong.service.impl;


import com.alkemy.ong.dto.CategoryGetDto;
import com.alkemy.ong.exception.ResourceNotFoundException;
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
import java.util.Optional;

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

    public void delete (Long id){
        Optional<Category> response = categoryRepository.findById(id);
        if(response.isPresent()) {
            categoryRepository.deleteById(id);
        }else{
                throw new ResourceNotFoundException(message.getMessage("category.notFound", null, Locale.US));
        }
    }

    @Transactional
    public CategoryDTO update (Long id, CategoryDTO dto){
        Optional<Category> response = categoryRepository.findById(id);
        if(response.isPresent()){
            Category category = response.get();
            category = categoryRepository.save(categoryMapper.updateCategoryFromDto(dto, category));
            return categoryMapper.categoryToCategoryDTO(category);
        }else {
            throw new ResourceNotFoundException(message.getMessage("category.notFound", null, Locale.US));
        }
    }
}
