package com.green.firstproject.common;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@OpenAPIDefinition(
        info = @Info(
                title = "1차 프로젝트",
                description = "",
                version = "v0.0.1"
        )
)
public class SwaggerConfiguration {
}
