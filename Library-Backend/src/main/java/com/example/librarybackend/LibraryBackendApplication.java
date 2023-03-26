package com.example.librarybackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LibraryBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryBackendApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/books/*").allowedOrigins("https://localhost:8080/");
				registry.addMapping("/#/books/*").allowedOrigins("https://localhost:4200/");
			}
		};
	}
}
