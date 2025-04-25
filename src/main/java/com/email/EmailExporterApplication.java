package com.email;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class EmailExporterApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmailExporterApplication.class, args);
	}

}
