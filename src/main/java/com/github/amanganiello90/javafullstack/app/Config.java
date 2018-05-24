package com.github.amanganiello90.javafullstack.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.embedded.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.Version;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleAbstractTypeResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.github.amanganiello90.javafullstack.app.models.User;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 *
 * @author amanganiello90 General configuration. It enables embedded mongo db
 */
@Configuration
@ComponentScan(basePackages = { "${db.package}" })
@EnableMongoRepositories(basePackages = { "${db.package}" })
public class Config {

	private static final Logger LOGGER = LoggerFactory.getLogger(JavaFullStackRunner.class);

	// value inserted in your application.properties server.port
	@Value("${server.port}")
	private String port;
	
	@Autowired
	User user;

	@EventListener(ApplicationReadyEvent.class)
	public void postConstruct() {
		LOGGER.info("-----OPEN BROWSER IN localhost:" + port);
	}

	@Bean
	public EmbeddedServletContainerCustomizer singlePageAppRouting() {
		return new EmbeddedServletContainerCustomizer() {
			@Override
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/"));
			}
		};
	}
	

	@Bean
	public ObjectMapper customJacksonObjectMapper() {

		ObjectMapper mapper = new ObjectMapper();

		SimpleModule module = new SimpleModule("CustomModel", Version.unknownVersion());

		SimpleAbstractTypeResolver resolver = new SimpleAbstractTypeResolver();
		
		// add all model to deserialize and serialize for post request with jackson object
		resolver.addMapping(User.class, user.factory().getClass());

		module.setAbstractTypes(resolver);

		mapper.registerModule(module);

		return mapper;
	}


}
