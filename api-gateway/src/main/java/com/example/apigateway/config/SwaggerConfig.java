package com.example.apigateway.config;

import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class SwaggerConfig {
    @Autowired
    RouteDefinitionLocator locator;

    @Bean
    public List<GroupedOpenApi> apis() {
        log.info("why not install");
        List<GroupedOpenApi> groups = new ArrayList<>();
        List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();
        definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*")).forEach(routeDefinition -> {
            String name = routeDefinition.getId();
            log.info("name = {}", name);
            GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
        });
        return groups;
    }
}
