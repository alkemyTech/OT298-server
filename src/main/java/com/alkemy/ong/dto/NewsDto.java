package com.alkemy.ong.dto;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class NewsDto {
    @NotNull(message="Name may not be empty.")
    private String name;

    @NotNull(message="Content may not be empty.")
    private String content;

    @NotNull(message="Image cannot be empty")
    private String image;

    @NotNull(message = "Category ID cannot be empty")
    private Long categoryId;
}
