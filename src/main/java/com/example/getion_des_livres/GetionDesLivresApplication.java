package com.example.getion_des_livres;


import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@Configuration
@OpenAPIDefinition(
		info = @Info(
				title = "Book Author REST API Documentation",
				description = " API Documentation for crud operations for books and authors",
				version = "v1",
				contact = @Contact(
						name = "chawali",
						email = "chawali@example.com",
						url = "https://www.site.com"
				)
		)
)

public class GetionDesLivresApplication implements WebMvcConfigurer {


	public static void main(String[] args) {
		SpringApplication.run(GetionDesLivresApplication.class, args);
	}

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// Allow requests from all origins with all methods and headers
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowedMethods("*")
				.allowedHeaders("*");
	}

}
