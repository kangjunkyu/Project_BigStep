package com.ssafy.bigstep;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan(basePackages = "com.ssafy.bigstep.model.dao")
@EnableSwagger2
public class BigStepApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(BigStepApplication.class, args);
	}

}
