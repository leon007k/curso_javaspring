package com.javaplatzispring.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*@ComponentScan(basePackages = {
		"com.javaplatzispring.app.persistence.mapper",
		"com.javaplatzispring.app.domain.domain",
		"com.javaplatzispring.app.persistence.entity",
		"com.javaplatzispring.app.persistence.crud",
		"com.javaplatzispring.app.domain.repository"
		})*/
/*@EnableJpaRepositories(basePackages = {
		"com.javaplatzispring.app.persistence.mapper",
		"com.javaplatzispring.app.domain.domain",
		"com.javaplatzispring.app.persistence.entity",
		"com.javaplatzispring.app.persistence.crud",
		"com.javaplatzispring.app.web.controller",
		"com.javaplatzispring.app.domain.repository",
		"com.javaplatzispring.app.domain.service",
		"com.javaplatzispring.app.persistence.persistence"
		})*/
@SpringBootApplication
@EnableJpaRepositories("com.javaplatzispring.app.domain.repository")
@ComponentScan(basePackages = {"com.javaplatzispring.app.persistence.crud"})
@EntityScan(basePackages = {"com.javaplatzispring.app.domain.persistence.entity"})
public class JavaplatzispringApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaplatzispringApplication.class, args);
	}

}
