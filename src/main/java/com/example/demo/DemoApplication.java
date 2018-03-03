package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class DemoApplication {

	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);

	// value inserted in your application.properties server.port
	@Value("${server.port}")
	private String port;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

	@EventListener(ApplicationReadyEvent.class)
	public void postConstruct() {
		logger.info("-----OPEN BROWSER IN localhost:" + port);
	}

	@Bean
	WebMvcConfigurer configurer() {
		return new WebMvcConfigurerAdapter() {
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {

				// registry.addResourceHandler("assets/**/*.*").addResourceLocations("classpath:/static");

			}

			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}

		};
	};

}
