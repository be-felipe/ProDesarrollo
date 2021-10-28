package com.desarrollo.barberia.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.desarrollo.barberia")
@EntityScan("com.desarrollo.barberia")
@EnableJpaRepositories("com.desarrollo.barberia")
@EnableAutoConfiguration

public class JpaApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
	}

}
