package com.alkemy.ong.config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;

@Configuration
@SecurityScheme(
        name = "Bearer Authentication",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        scheme = "bearer"
)
public class OpenAPIConfig {
    @Autowired
    MessageSource messageSource;

    @Bean
    public OpenAPI OngAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title(messageSource.getMessage("api.title", null, Locale.US))
                        .description(messageSource.getMessage("api.description", null, Locale.US))
                        .version(messageSource.getMessage("api.version", null, Locale.US)))
                .externalDocs(new ExternalDocumentation()
                        .description(messageSource.getMessage("api.externalDocumentationDescription", null, Locale.US))
                        .url(messageSource.getMessage("api.repositoryUrl", null, Locale.US)));
    }
}
