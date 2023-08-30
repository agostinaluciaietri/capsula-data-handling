package com.ejerciciosjavasharks.ejerciciodatahandling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class EjercicioDataHandlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioDataHandlingApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create()
				.driverClassName("com.mysql.cj.jdbc.Driver")
				.url("jdbc:mysql://localhost:3306/datahandlingdb")
				.username("root")
				.build();
	}
}
