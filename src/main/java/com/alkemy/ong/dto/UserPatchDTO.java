package com.alkemy.ong.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserPatchDTO {
    private String firstName;
    private String lastName;
    private String password;
    private String photo;
}
