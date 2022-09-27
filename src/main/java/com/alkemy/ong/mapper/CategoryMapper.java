package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.CategoryGetDto;
import com.alkemy.ong.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "name", source = "category.name")
    CategoryGetDto categoryToCategoryGetDto (Category category);
    List<CategoryGetDto> listCategoriesToListDtos (List<Category> categories);
}
