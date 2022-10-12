package com.alkemy.ong.documentation;

import com.alkemy.ong.dto.CategoryCompleteGetDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

import static com.alkemy.ong.util.Constants.FIRST_PAGE;
import static com.alkemy.ong.util.Constants.httpCodes.*;
import static com.alkemy.ong.util.Constants.messagesForDocs.*;

@RequestMapping("categories")
public interface CategoryDoc {

    @Operation(summary = GET_CATEGORIES)
    @SecurityRequirement(name = BEARER_AUTH)
    @ApiResponses(value = {
            @ApiResponse(responseCode = STATUS_OK, description = GET_CATEGORIES_SUCCESSFUL, content = @Content),
            @ApiResponse(responseCode = STATUS_BAD_REQUEST, description = INVALID_PAGE, content = @Content),
            @ApiResponse(responseCode = STATUS_NOT_FOUND, description = PAGE_NOT_FOUND, content = @Content),
            @ApiResponse(responseCode = STATUS_NO_CONTENT, description = NO_CATEGORIES, content = @Content),
            @ApiResponse(responseCode = STATUS_FORBIDDEN, description = FORBIDDEN, content = @Content)
    })
    @GetMapping(params = "page")
    ResponseEntity<Map<String, Object>> getAllCategories(
            @RequestParam(defaultValue = FIRST_PAGE, required = false) Integer page);

    @Operation(summary = GET_CATEGORY_ID)
    @SecurityRequirement(name = BEARER_AUTH)
    @ApiResponses(value = {
            @ApiResponse(responseCode = STATUS_OK, description = GET_CATEGORY_SUCCESSFUL, content = @Content),
            @ApiResponse(responseCode = STATUS_NOT_FOUND, description = CATEGORY_NOT_FOUND, content = @Content),
            @ApiResponse(responseCode = STATUS_FORBIDDEN, description = FORBIDDEN, content = @Content)
    })
    @GetMapping("/{id}")
    ResponseEntity<CategoryCompleteGetDto> getCategoryById(@PathVariable Long id);
}
