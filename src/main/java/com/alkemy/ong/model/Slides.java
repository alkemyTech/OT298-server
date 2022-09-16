package com.alkemy.ong.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "slides")
@Getter
@Setter
public class Slides {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "organization_id")
    private Long organizationId;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "text_img")
    private String text;
    @Column(name = "order_img")
    private int order;

}
