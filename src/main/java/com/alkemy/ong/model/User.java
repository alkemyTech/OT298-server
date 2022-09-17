package com.alkemy.ong.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id=?")
@Where(clause= "deleted = false")
@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Long id;

    @NotBlank
    @Column(name="first_name", nullable = false)
    private String firstName;

    @NotBlank
    @Column(name="last_name", nullable = false)
    private String lastName;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]{8,16}$")
    @Column(nullable = false)
    private String password;

    @Nullable
    private String photo;

    @NotBlank
    @Column(name = "role_id", nullable = false)
    private Long roleId;

    @Nullable
    private boolean deleted = Boolean.FALSE;

    @NotBlank
    @CreationTimestamp
    @Column(name="creation_date", updatable = false, nullable = false)
    private Timestamp creationDate;

    @NotBlank
    @UpdateTimestamp
    @Column(name="last_updated", nullable = false)
    private Timestamp lastUpdated;
}
