package com.alkemy.ong.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class CategoryDTO {

    private Long id;

    @NotNull(message = "{request.name}")
    @Pattern(regexp = "^[A-Za-z]*$", message = "{request.letters}")
    private String name;

    private String description;

    private String image;
}
