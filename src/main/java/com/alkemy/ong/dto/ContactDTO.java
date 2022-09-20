package com.alkemy.ong.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class ContactDTO {

    private Long id;

    @NotBlank
    @Pattern(regexp = "^[A-Za-z]*$")
    private String name;

    @NotBlank
    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;

    @NotNull
    @Email
    private String email;

    @NotNull
    private String message;
}
