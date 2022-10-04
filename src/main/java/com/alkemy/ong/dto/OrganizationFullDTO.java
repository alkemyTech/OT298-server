package com.alkemy.ong.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class OrganizationFullDTO {

    private Long id;

    @NotNull(message = "{request.name}")
    private String name;

    @NotNull(message = "{request.image}")
    private String image;

    private String address;

    private Integer phone;

    private String urlLinkedin;

    private String urlFacebook;

    private String urlInstagram;

    @Email
    @NotNull(message = "{request.email}")
    private String email;

    @NotNull(message = "{request.field}")
    private String welcomeText;

    private String aboutUsText;
}
