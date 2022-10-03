package com.alkemy.ong.security.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserGetDto {

    private String firstName;
    private String email;
    private String nameRole;
    private String jwtToken;

}
