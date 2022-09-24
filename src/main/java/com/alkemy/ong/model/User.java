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

    @NotBlank (message = "First name is required")
    @Pattern(regexp = "^[A-Za-z]*$")
    @Column(name="first_name", nullable = false)
    private String firstName;

    @NotBlank (message = "Last name is required")
    @Pattern(regexp = "^[A-Za-z]*$")
    @Column(name="last_name", nullable = false)
    private String lastName;

    @Email (message = "Email name is required")
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank(message = "Password is required")
    @Column(nullable = false)
    private String password;

    @Nullable
    private String photo;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_role", nullable = false)
    private Role role;

    @Nullable
    private boolean deleted = Boolean.FALSE;

    @CreationTimestamp
    @Column(name="creation_date", updatable = false)
    private Timestamp creationDate;

    @UpdateTimestamp
    @Column(name="last_updated")
    private Timestamp lastUpdated;
}
