package com.example.apigateway.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(info = @Info(title = "[Cart Service] API 명세서", version = "0.1", description = "Cart Information"))
public class SwaggerConfig {

}
