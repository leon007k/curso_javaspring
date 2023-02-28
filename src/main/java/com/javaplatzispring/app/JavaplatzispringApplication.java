package com.javaplatzispring.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {
		"com.javaplatzispring.app.persistence.mapper",
		"com.javaplatzispring.app.domain.domain",
		"com.javaplatzispring.app.persistence.entity",
		"com.javaplatzispring.app.persistence.crud"})
@SpringBootApplication
public class JavaplatzispringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaplatzispringApplication.class, args);
	}

}
