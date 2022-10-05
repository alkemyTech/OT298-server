package com.alkemy.ong.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrganizationBasicDTO {
    private String name;
    private Integer phone;
    private String address;
    private String image;
    private List<SlidesDto> slides;

}
