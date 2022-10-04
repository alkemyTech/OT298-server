package com.alkemy.ong.dto;


import com.alkemy.ong.model.Slides;
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
    private List<SlidesDTO> slides;
    private String urlLinkedin;
    private String urlFacebook;
    private String urlInstagram;

}
