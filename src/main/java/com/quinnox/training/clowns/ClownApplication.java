package com.quinnox.training.clowns;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication()
@EnableJpaRepositories(basePackages = "com.quinnox.training.clowns")
@ComponentScan(basePackages = "com.quinnox.training.clowns")
public class ClownApplication {
	
	public static void main(String... args) {
		SpringApplication.run(ClownApplication.class, args);
	}
}
