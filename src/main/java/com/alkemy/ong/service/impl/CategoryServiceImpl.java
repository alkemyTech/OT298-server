package com.alkemy.ong.service.impl;

import com.alkemy.ong.dto.CategoryGetDto;
import com.alkemy.ong.exception.ArrayIsEmpty;
import com.alkemy.ong.mapper.CategoryMapper;
import com.alkemy.ong.model.Category;
import com.alkemy.ong.repository.CategoryRepository;
import com.alkemy.ong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;

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
            throw new ArrayIsEmpty(message.getMessage("array.isEmpty", null, Locale.US));
        }
        List<CategoryGetDto> listDtosCategories = categoryMapper.listCategoriesToListDtos(categories);
        return listDtosCategories;
    }
}
