package com.packt.learnjava.spring;

import io.github.resilience4j.common.circuitbreaker.configuration.CircuitBreakerConfigCustomizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestClient;

@SpringBootApplication
@EnableScheduling
@EnableCaching
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CircuitBreakerConfigCustomizer circuitBreakerCustomizer() {
		return CircuitBreakerConfigCustomizer.of("circuitBreakerDemo", builder -> builder.minimumNumberOfCalls(1)
				.permittedNumberOfCallsInHalfOpenState(15));
	}

	//Used in Chapter 16. Java Microservices
	@Bean
	public RestClient restClient1() {
		return RestClient.builder()
				.baseUrl("http://localhost:3333")
				.build();
	}

	@Bean
	public RestClient restClient2() {
		return RestClient.builder()
				.baseUrl("http://localhost:8082")
				.build();
	}
}


