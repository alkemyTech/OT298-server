package com.alkemy.ong.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.sql.Timestamp;

@Entity
@Table(name = "activities")
@SQLDelete(sql = "UPDATE activities SET softDelete = true WHERE id=?")
@Where(clause = "softDelete=false")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "name", nullable = false)
    private String name;
    @Column(name= "context", nullable = false)
    private String content;
    @Column(name= "image", nullable = false)
    private String image;

   	@Column(name = "timestamps")
  	@CreationTimestamp
 	  private Timestamp timestamps;

  	@Column(name = "softDelete")
  	private boolean softDelete;
}