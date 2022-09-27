package com.alkemy.ong.controller;

import com.alkemy.ong.dto.CategoryGetDto;
import com.alkemy.ong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    private ResponseEntity<List<CategoryGetDto>> getAllCategories(){
        List<CategoryGetDto> categories = categoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }
}
