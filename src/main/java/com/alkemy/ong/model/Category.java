package com.alkemy.ong.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "categories")
@Getter
@Setter
@SQLDelete(sql = "UPDATE categories SET deleted = true WHERE id=?")
@Where(clause = "softDelete=false")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;// VARCHAR NOT NULL
    private String description; //VARCHAR NULLABLE
    private String image; //VARCHAR NULLABLE
    private LocalDate timestamps;
    private boolean softDelete = Boolean.FALSE;

}
