package com.drarc.gatewayserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

@SpringBootApplication
public class GatewayserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayserverApplication.class, args);
	}

	/**
	 * Creates a custom route configuration for the API Gateway.
	 * This bean defines how incoming requests are routed to different microservices.
	 * 
	 * @param builder The RouteLocatorBuilder used to construct the routes
	 * @return A RouteLocator containing the defined routes
	 */
	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				// Route for Accounts microservice
				.route("accounts", r -> r.path("/easybank/accounts/**")
						.filters(f -> f
								// Rewrite the path by removing the 'easybank/accounts' prefix
								// (?<segment>.*) captures the remaining path and stores it in 'segment'
								.rewritePath("/easybank/accounts/(?<segment>.*)", "/${segment}")
								// Add a response header with the current timestamp
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						// Route to the ACCOUNTS service using load balancing
						.uri("lb://ACCOUNTS"))
				
				// Route for Loans microservice
				.route("loans", r -> r.path("/easybank/loans/**")
						.filters(f -> f
								// Similar path rewriting for loans service
								.rewritePath("/easybank/loans/(?<segment>.*)", "/${segment}")
								.addResponseHeader("X-Response-Time", LocalDateTime.now().toString()))
						// Route to the LOANS service using load balancing
						.uri("lb://LOANS"))
				.build();
	}
} 