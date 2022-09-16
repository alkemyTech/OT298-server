package com.alkemy.ong.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "members")
@Setter
@Getter
@SQLDelete(sql = "UPDATE members SET deleted = true WHERE id = ?")
@Where(clause = "deleted = false")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "facebook_url", nullable = false)
    private String facebookUrl;

    @Column(name = "instagram_url", nullable = false)
    private String instagramUrl;

    @Column(name = "linkedin_url", nullable = false)
    private String linkedinUrl;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String description;

    @Column(name = "created_at", nullable = false)
    private LocalDate createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDate updatedAt;

    @Column(nullable = false)
    private boolean deleted = Boolean.FALSE;
}
