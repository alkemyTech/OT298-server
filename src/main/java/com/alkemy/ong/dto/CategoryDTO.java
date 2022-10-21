package com.alkemy.ong.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {

    private Long id;

    @NotNull(message = "{request.name}")
    @Pattern(regexp = "^[A-Za-z]*$", message = "{request.letters}")
    private String name;

    private String description;

    private String image;
}
