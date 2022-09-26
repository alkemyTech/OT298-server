package com.alkemy.ong.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ActivityDTO {

    private Long id;

    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "Content cannot be empty")
    @Lob
    private String content;

    @NotNull(message = "Image cannot be empty")
    private String image;
}
