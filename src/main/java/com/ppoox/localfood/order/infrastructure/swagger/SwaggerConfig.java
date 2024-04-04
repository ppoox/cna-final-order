package com.ppoox.localfood.order.infrastructure.swagger;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;

//@Configuration
public class SwaggerConfig {
    public OpenAPI baseApi() {
        return new OpenAPI().info(new Info().title("Order Service")
                .description("Order Service API"));
    }

//    @Bean
    public GroupedOpenApi allApi() {
        return GroupedOpenApi.builder().group("All")
                .packagesToScan("com.ppoox.localfood.order.adapter.in.presentation").build();
    }

}
