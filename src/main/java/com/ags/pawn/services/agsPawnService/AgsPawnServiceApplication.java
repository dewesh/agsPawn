package com.ags.pawn.services.agsPawnService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AgsPawnServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgsPawnServiceApplication.class, args);
	}
}
