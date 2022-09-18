package com.alkemy.ong.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name= "news")
@Getter
@Setter
@SQLDelete(sql= "Update news SET deleted = true WHERE id=?")
@Where(clause= "deleted=false")

public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message="name is required")
    private String name;


    @NotNull(message="content is empty")
    private String content;


    @NotNull(message="image not found")
    private String image;

    @Column(name="category_id")
    private Long categoryId;

    @Column(name = "CREATION_DATE")
    @CreationTimestamp
    private LocalDateTime creationDate;

    @Column(name = "update_date")
    @UpdateTimestamp
    private LocalDateTime updateDate;

    private boolean deleted = Boolean.FALSE;
}
