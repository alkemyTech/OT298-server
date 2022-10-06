package com.alkemy.ong.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
public class CommentDto {

    private  Long id;

    @NotBlank(message = "{body.empty}")
    private String body;

    @Min(value = 1,message = "{id.zero}")
    @NotNull(message = "{id.invalid}")
    private Long userId;

    @Min(value = 1,message = "{id.zero}")
    @NotNull(message = "{id.invalid}")
    private Long newsId;


    @CreationTimestamp
    private Timestamp creationDate;

    @UpdateTimestamp
    private Timestamp updateDate;

}
