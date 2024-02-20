package ru.gbhw.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class ApiGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }

    @Bean
    public RouteLocator changeRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("ms1", route -> route.path("/ms1/**").uri("http://localhost:8081/"))
                .route("ms2", route -> route.path("/ms2/**").uri("http://localhost:8082/"))
                .build();
    }
}
