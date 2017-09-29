package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	// value inserted in your application.properties server.port
	private static final String port = "8081";

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("OPEN BROWSER IN localhost:" + port);
	}
}
