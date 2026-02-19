package com.api.heyGateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.GatewayFilterSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Mono;

import java.util.LinkedList;



@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	RouteLocatorBuilder builder = null;

	@Bean
	public RouteLocator movieOnlyRootRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/api/movies/**")
						.filters(f -> f
								.rewritePath("/api/?(?<segment>.*)/", "/${segment}")
								.prefixPath("/")
							.addResponseHeader("X-Powered-By","Houssam's Movies  Gateway Service")
								.addResponseHeader("Host-Institution","University of Western Brittany's API  Gateway Service")
						)
						.uri("http://localhost:9001")
				)
				.build();
		//Je le laisse pour plus tard, pour des manipulation plus precise : .rewritePath("/api/movies/(?<path>.*)", "/movies/${path}")

	}

	@Bean
	public RouteLocator movieRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/api/movies/**")
						.filters(f -> f
								.prefixPath("/")
								.addResponseHeader("X-Powered-By","Houssam's Movies  Gateway Service")
								.addResponseHeader("Host-Institution","University of Western Brittany's API  Gateway Service")
						)
						.uri("http://localhost:9001")
				)
				.route(r -> r.host("http://localhost:9000/api/movies/")
						.uri("http://localhost:9001/movies")
				)
				.build();

	}

	@Bean
	public RouteLocator userRouteLocator(RouteLocatorBuilder builder){
			return builder.routes()
					.route(r -> r.path("/api/users/**")
					.filters(f -> f
						.prefixPath("/")
							.stripPrefix(1)
						.addResponseHeader("X-Powered-By","Houssam's Users  Gateway Service")
							.addResponseHeader("Host-Institution","University of Western Brittany's API  Gateway Service")

					)
				.uri("http://localhost:9004"))
					.build();
	}

	@Bean
	public RouteLocator AuthenticationRouteLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r -> r.path("/api/authentication/**")
						.filters(f -> f
								.prefixPath("/")
								.stripPrefix(1)
								.addResponseHeader("X-Powered-By","Houssam's Authentication  Gateway Service")
								.addResponseHeader("Host-Institution","University of Western Brittany's API  Gateway Service")

						)
						.uri("http://localhost:9010"))
				.build();
	}

	@Bean
	public RouteLocator artistRouteLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r -> r.path("/api/artists/**")
						.filters(f -> f
								.prefixPath("/")
								.stripPrefix(1)
								.addResponseHeader("X-Powered-By","Houssam's Artist  Gateway Service")
								.addResponseHeader("Host-Institution","University of Western Brittany's API  Gateway Service")

						)
						.uri("http://localhost:9003"))
				.build();
	}

	@Bean
	public RouteLocator reservationRouteLocator(RouteLocatorBuilder builder){
		return builder.routes()
				.route(r -> r.path("/api/reservations/**")
						.filters(f -> f
								.prefixPath("/")
								.stripPrefix(1)
								.addResponseHeader("X-Powered-By","Houssam's Reservation Gateway Service")
								.addResponseHeader("Host-Institution","University of Western Brittany's API  Gateway Service")

						)
						.uri("http://localhost:9006"))
				.build();
	}

}
