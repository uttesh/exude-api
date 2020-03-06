package com.uttesh.exude;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ExudeOpenAPIConfig {

    @Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info().title("Exude API Service").description("Excude API Service")
				.contact(new Contact().name("Uttesh").url("http://uttesh.com").email("uttesh@gmail.com"))
				.license(new License().name("The Apache License").url("https://github.com/uttesh/exude-api/blob/master/LICENSE")));
	}
}
