package com.green.firstproject.common;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
@OpenAPIDefinition(
        info = @Info(
                title = "그린그램",
                description = "Greengram with react",
                version = "v0.0.3"
        )
)
public class SwaggerConfiguration {
}
