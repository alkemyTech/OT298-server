package com.alkemy.ong.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizationBasicDTO {
    private String name;
    private Integer phone;
    private String address;
    private String image;

    public OrganizationBasicDTO(String name, Integer phone, String address, String image) {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.image = image;
    }
}
