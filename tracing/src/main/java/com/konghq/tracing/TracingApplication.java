package com.konghq.tracing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@SpringBootApplication
public class TracingApplication {

	@Bean
	public SlowService slowService() {
		return new SlowService();
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.setConnectTimeout(Duration.ofMillis(1000))
				.setReadTimeout(Duration.ofMillis(1000))
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(TracingApplication.class, args);
	}

}
