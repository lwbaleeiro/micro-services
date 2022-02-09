[![Continuous Integration with Github](https://github.com/lwbaleeiro/micro-services/actions/workflows/docker-publish.yml/badge.svg)](https://github.com/lwbaleeiro/micro-services/actions/workflows/docker-publish.yml)

## Requerimentos:
Java 17 ou superior \
Docker 4.4.4 ou superior

## Após subir os containers:
**Zipkin**: http://localhost:9411/zipkin/ \
**Rabit**: http://localhost:15672/#/ \
**Eureka**: http://localhost:8761/ \
**Swagger**: http://localhost:8765/swagger-ui.html

## Tecnologias utilizadas: 
* Spring Cloud Configuration;
* Spring Boot Actuator;
* Feign;
* Service Discovery e Service Registry com Eureka;
* Load Balancing com Eureka, Feign e Spring Cloud LoadBalancer;
* API Gateway e RouteLocator com Spring Cloud Gateway;
* Circuit Breaker com Resilience4j;
* Swagger OpenAPI nos microsserviços;
* Distributed Tracing com Docker, Zipkin, Eureka e Sleuth;
* Dockerização, entrega contínua com Github Actions.