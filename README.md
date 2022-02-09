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
- [Spring Cloud Configuration](#spring-cloud);
- [Spring Boot Actuator](#spring-boot-actuator);
- [Feign](#feign);
- [Service Discovery e Service Registry com Eureka](#eureka);
- [Load Balancing com Eureka, Feign e Spring Cloud LoadBalancer](#loadBalancer);
- [API Gateway e RouteLocator com Spring Cloud Gateway](#spring-cloud-gateway);
- [Circuit Breaker com Resilience4j](#resilience4j);
- [Swagger OpenAPI nos microsserviços](#swagger);
- Distributed Tracing com Docker, [Zipkin](#zipkin), [Eureka](#eureka) e [Sleuth](#sleuth);
- Dockerização, entrega contínua com Github Actions.


## Spring Cloud
Spring Cloud provides tools for developers to quickly build some of the common patterns in distributed systems (e.g. configuration management, service discovery, circuit breakers, intelligent routing, micro-proxy, control bus, one-time tokens, global locks, leadership election, distributed sessions, cluster state). [More about spring clound](https://spring.io/projects/spring-cloud#overview) 

## Spring Boot Actuator
A framework to help you monitor and manage your application. You can choose to manage and monitor your application by using HTTP endpoints or with JMX. Auditing, health, and metrics gathering can also be automatically applied to your application. [More about Spring Actuator](https://docs.spring.io/spring-boot/docs/2.5.6/reference/html/actuator.html)

## Feign
Feign is a Java to HTTP client binder inspired by Retrofit, JAXRS-2.0, and WebSocket. Feign's first goal was reducing the complexity of binding Denominator uniformly to HTTP APIs regardless of ReSTfulness. [More about Feign](https://github.com/OpenFeign/feign)

## Eureka
Client-side service discovery allows services to find and communicate with each other without hard-coding hostname and port. [More about Eureka](https://spring.io/projects/spring-cloud-netflix)

## LoadBalancer
A load balancer does exactly what its name suggests – efficiently balances server load. It sits in between the user, or ‘client’, and the server cluster and distributes all the requests from users (like a video, text, application data, or image) across all servers capable of fulfilling those requests, which may be local within the same data center or geographically dispersed across the internet or private networks. [More about LoadBalancer](https://www.loadbalancer.org/blog/what-is-a-load-balancer/)

## Spring Cloud Gateway
In a distributed environment, services need to communicate with each other. However, this is interservice communication. We also have use-cases where a client outside our domain wants to hit our services for the API. So, either we can expose the address of all our microservices which can be called by clients OR we can create a Service Gateway which routes the request to various microservices and responds to the clients. [More about Spring Cloud Gateway](https://tanzu.vmware.com/developer/guides/scg-what-is/)

## Resilience4j
The concept of a circuit breaker is to prevent calls to microservice when it’s known the call may fail or time out. This is done so that clients don’t waste their valuable resources handling requests that are likely to fail. Using this concept, you can give the server some spare time to recover. [More About Resilience4j](https://medium.com/bliblidotcom-techblog/resilience4j-circuit-breaker-implementation-on-spring-boot-9f8d195a49e0)

## Swagger
Swagger allows you to describe the structure of your APIs so that machines can read them. The ability of APIs to describe their own structure is the root of all awesomeness in Swagger. Why is it so great? Well, by reading your API’s structure, we can automatically build beautiful and interactive API documentation [More about Swagger](https://swagger.io/docs/specification/2-0/what-is-swagger/)

##  Zipkin
Zipkin is a distributed tracing system. It helps gather timing data needed to troubleshoot latency problems in service architectures. Features include both the collection and lookup of this data. [More about Zipkin](https://zipkin.io/)

## Sleuth
This library makes it possible to identify logs pertaining to a specific job, thread, or request. Sleuth integrates effortlessly with logging frameworks like Logback and SLF4J to add unique identifiers that help track and diagnose issues using logs. [More about Sleuth](https://www.baeldung.com/spring-cloud-sleuth-single-application)