package com.alkemy.ong.security.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class UserPostDto {

    @NotBlank (message = "First name is required")
    @Pattern(regexp = "^[A-Za-z]*$")
    @NotNull
    private String firstName;

    @NotBlank (message = "Last name is required")
    @Pattern(regexp = "^[A-Za-z]*$")
    @NotNull
    private String lastName;

    @Email
    @Email (message = "Email name is required")
    @NotNull
    private String email;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–{}:;',?/*~$^+=<>]).{8,20}$")
    @NotNull
    private String password;

    @NotBlank(message = "Role is required")
    @NotNull
    private String nameRole;

    private String photo;
}
