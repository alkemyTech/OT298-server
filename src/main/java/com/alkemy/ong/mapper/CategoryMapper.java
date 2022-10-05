package com.alkemy.ong.mapper;

import java.util.List;

import com.alkemy.ong.dto.CategoryGetDto;
import com.alkemy.ong.dto.CategoryDTO;
import com.alkemy.ong.model.Category;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(target = "name", source = "category.name")
    CategoryGetDto categoryToCategoryGetDto (Category category);
    
    List<CategoryGetDto> listCategoriesToListDtos (List<Category> categories);

    CategoryDTO categoryToCategoryDTO (Category entity);

    Category categoryDTOToCategory (CategoryDTO dto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Category updateCategoryFromDto(CategoryDTO dto, @MappingTarget Category category);

}
