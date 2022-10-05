package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.CategoryDTO;
import com.alkemy.ong.dto.CategoryGetDto;
import com.alkemy.ong.model.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-05T11:36:31-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.16 (Ubuntu)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryGetDto categoryToCategoryGetDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryGetDto categoryGetDto = new CategoryGetDto();

        categoryGetDto.setName( category.getName() );

        return categoryGetDto;
    }

    @Override
    public List<CategoryGetDto> listCategoriesToListDtos(List<Category> categories) {
        if ( categories == null ) {
            return null;
        }

        List<CategoryGetDto> list = new ArrayList<CategoryGetDto>( categories.size() );
        for ( Category category : categories ) {
            list.add( categoryToCategoryGetDto( category ) );
        }

        return list;
    }

    @Override
    public CategoryDTO categoryToCategoryDTO(Category entity) {
        if ( entity == null ) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId( entity.getId() );
        categoryDTO.setName( entity.getName() );
        categoryDTO.setDescription( entity.getDescription() );
        categoryDTO.setImage( entity.getImage() );

        return categoryDTO;
    }

    @Override
    public Category categoryDTOToCategory(CategoryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Category category = new Category();

        category.setId( dto.getId() );
        category.setName( dto.getName() );
        category.setDescription( dto.getDescription() );
        category.setImage( dto.getImage() );

        return category;
    }

    @Override
    public Category updateCategoryFromDto(CategoryDTO dto, Category category) {
        if ( dto == null ) {
            return null;
        }

        if ( dto.getId() != null ) {
            category.setId( dto.getId() );
        }
        if ( dto.getName() != null ) {
            category.setName( dto.getName() );
        }
        if ( dto.getDescription() != null ) {
            category.setDescription( dto.getDescription() );
        }
        if ( dto.getImage() != null ) {
            category.setImage( dto.getImage() );
        }

        return category;
    }
}
