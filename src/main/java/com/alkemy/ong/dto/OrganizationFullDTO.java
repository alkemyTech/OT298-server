package com.alkemy.ong.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;

@Getter
@Setter
public class OrganizationFullDTO {

    private String name;

    private String image;

    private String address;

    private Integer phone;

    private String urlLinkedin;

    private String urlFacebook;

    private String urlInstagram;

    @Email
    private String email;

    private String welcomeText;

    private String aboutUsText;
}
