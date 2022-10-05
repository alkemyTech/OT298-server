package com.alkemy.ong.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SlidesDto implements Serializable {
    private String image;
    private String text;
    private int orders;
}
