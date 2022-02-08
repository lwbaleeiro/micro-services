package br.com.apigateway.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
*
*     ESSA CONFIGURAÇÃO FOI MIGRADA PARA O APPLICATION.YML
*     MANTIDA PARA FINS DIDATICOS.
*
* */

//@Configuration
public class ApiGatewayConfiguration {

//    @Bean
//    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
//
//        return builder.routes()
//                .route(predicateSpec -> predicateSpec
//                        .path("/get")
//                        .uri("http://httpbin.org:80")
//                )
//                .route(predicateSpec -> predicateSpec
//                        .path("/cambio-service/**")
//                        .uri("lb://cambio-service")
//                )
//                .route(predicateSpec -> predicateSpec
//                        .path("/book-service/**")
//                        .uri("lb://book-service")
//                )
//                .build();
//    }
}
