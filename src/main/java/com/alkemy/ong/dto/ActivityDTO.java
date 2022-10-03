package com.alkemy.ong.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Lob;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ActivityDTO {

    private Long id;

    @NotNull(message = "{request.name}")
    private String name;

    @NotNull(message = "{request.content}")
    @Lob
    private String content;

    @NotNull(message = "{request.image}")
    private String image;
}
