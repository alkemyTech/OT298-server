package com.alkemy.ong.dto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class MemberDTO {

    private Long id;

    @NotNull(message = "name is required")
    private String name;

    private String facebookUrl;

    private String instagramUrl;

    private String linkedinUrl;

    @NotNull(message = "image is required")
    private String image;

    private String description;

}
