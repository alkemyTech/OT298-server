package com.alkemy.ong.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

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

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Email
    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    @Pattern(regexp = "^[a-zA-Z0-9]{8,16}$")
    private String password;

    private String photo;

    @Column(name = "role_id", nullable = false)
    private Long roleId;

    private boolean deleted = Boolean.FALSE;

    @Column(name="creation_date", updatable = false)
    @CreationTimestamp
    private Timestamp creationDate;

    @Column(name="last_updated")
    @UpdateTimestamp
    private Timestamp lastUpdated;
}
