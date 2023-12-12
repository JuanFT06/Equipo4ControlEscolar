package com.example.Equipo4Controlescolar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class Equipo4ControlescolarApplication {

	public static void main(String[] args) {
		SpringApplication.run(Equipo4ControlescolarApplication.class, args);
	}

}
