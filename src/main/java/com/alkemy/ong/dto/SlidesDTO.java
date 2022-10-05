package com.alkemy.ong.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SlidesDTO {

    private Long id;

    private String image;

    private String text;

    private Integer position;
}