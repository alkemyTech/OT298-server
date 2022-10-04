package com.alkemy.ong.mapper;

import com.alkemy.ong.dto.CategoryCompleteGetDto;
import com.alkemy.ong.dto.CategoryDTO;
import com.alkemy.ong.dto.CategoryGetDto;
import com.alkemy.ong.model.Category;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-10-04T00:14:12-0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Private Build)"
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
    public CategoryCompleteGetDto categoryToCategoryCompleteGetDto(Category category) {
        if ( category == null ) {
            return null;
        }

        CategoryCompleteGetDto categoryCompleteGetDto = new CategoryCompleteGetDto();

        categoryCompleteGetDto.setId( category.getId() );
        categoryCompleteGetDto.setName( category.getName() );
        categoryCompleteGetDto.setDescription( category.getDescription() );
        categoryCompleteGetDto.setImage( category.getImage() );
        categoryCompleteGetDto.setCreationDate( category.getCreationDate() );
        categoryCompleteGetDto.setUpdateDate( category.getUpdateDate() );
        categoryCompleteGetDto.setDeleted( category.isDeleted() );

        return categoryCompleteGetDto;
    }
}
