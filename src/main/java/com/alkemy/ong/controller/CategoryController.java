package com.alkemy.ong.controller;

import com.alkemy.ong.dto.CategoryCompleteGetDto;
import com.alkemy.ong.dto.CategoryGetDto;
import com.alkemy.ong.dto.CategoryDTO;
import com.alkemy.ong.model.Category;
import com.alkemy.ong.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryGetDto>> getAllCategories(){
        List<CategoryGetDto> categories = categoryService.getAllCategories();
        return ResponseEntity.status(HttpStatus.OK).body(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryCompleteGetDto> getCategoryById(@PathVariable Long id){
        CategoryCompleteGetDto category = categoryService.getCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    @PostMapping
    public ResponseEntity<CategoryDTO> saveCategory (@Valid @RequestBody CategoryDTO dto){

        CategoryDTO savedCategory = categoryService.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryDTO> updateCategory(@PathVariable Long id, @Valid @RequestBody CategoryDTO dto){
        CategoryDTO categoryUpdated = categoryService.update(id, dto);
        return ResponseEntity.ok().body(categoryUpdated);
    }
}
