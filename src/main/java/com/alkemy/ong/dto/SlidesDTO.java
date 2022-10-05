package com.alkemy.ong.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SlidesDTO implements Serializable {
    private String image;
    private String text;
    private int orders;
}
