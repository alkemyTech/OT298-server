package com.alkemy.ong.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Table(name="organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    private Long id;

    @NotNull
    @Column(name = "organization_name")
    private String name;

    @NotNull
    @Column(name = "organization_image")
    private String image;

    @Column(name = "organization_address")
    private String address;

    @Column(name = "organization_phone")
    private Integer phone;

    @NotNull
    @Column(name = "organization_email")
    private String email;

    @NotNull
    @Column(name = "organization_welcome_text", columnDefinition = "TEXT")
    private String welcomeText;

    @Column(name = "organization_about_us_text", columnDefinition = "TEXT")
    private String aboutUsText;

    @NotNull
    @Column(name="organization_deleted")
    private Boolean deleted;

    @NotNull
    @Column(name="organization_creation_date")
    private LocalDateTime creationDate;

    @Column(name="organization_update_date")
    private LocalDateTime updateDate;

    @Column(name="organization_removal_date")
    private LocalDateTime removalDate;

}
