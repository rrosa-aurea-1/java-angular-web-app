package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@RestController
public class DemoApplication {
	
  @RequestMapping("/resource")
  String hello(@PathVariable String name) {
    return "Hello, " + name + "!";
  }

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
