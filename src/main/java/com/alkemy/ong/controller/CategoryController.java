package com.alkemy.ong.controller;

import com.alkemy.ong.dto.CategoryGetDto;
import com.alkemy.ong.dto.CategoryDTO;
import com.alkemy.ong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    //TODO: @RolesAllowed("ADMIN")
    @PostMapping
    public ResponseEntity<CategoryDTO> saveCategory (@Valid @RequestBody CategoryDTO dto){

        CategoryDTO savedCategory = categoryService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);

    }

    @PostMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO dto){
        CategoryDTO categoryUpdated = categoryService.update(id, dto);
        return ResponseEntity.ok().body(categoryUpdated);
    }
}
