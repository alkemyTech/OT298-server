package com.alkemy.ong.dto;

import com.alkemy.ong.model.Organization;
import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SlidesDTO implements Serializable {


    private Long id;

    private String image;

    private String text;

    private Integer position;

    private Integer OrgId;

}
