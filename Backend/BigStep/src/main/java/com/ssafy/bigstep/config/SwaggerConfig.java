package com.ssafy.bigstep.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		ApiInfo apiInfo = new ApiInfoBuilder()
				.title("BigStep REST API")
				.description("<h3>BigStep REST API에 대한 문서입니다.</h3>")
				.contact(new Contact("SSAFY", "https://edu.ssafy.com", "ssafy@ssafy.com"))
//				.license("MIT License")
				.version("1.5").build();

		return new Docket(DocumentationType.SWAGGER_2) 
				.apiInfo(apiInfo) 
				.select() 
				.apis(RequestHandlerSelectors.basePackage("com.ssafy.bigstep.controller"))
//				.apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
				.build();
	}
}
