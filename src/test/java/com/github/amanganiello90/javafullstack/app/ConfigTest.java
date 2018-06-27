package com.github.amanganiello90.javafullstack.app;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.amanganiello90.javafullstack.app.JavaFullStackRunner;
import com.jayway.restassured.RestAssured;

/**
 *
 * @author amanganiello90 Api automatic integration tests configuration class
 */
@SpringApplicationConfiguration(classes = JavaFullStackRunner.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
@ActiveProfiles("h2")
public abstract class ConfigTest {

	@Value("${local.server.port}")
	protected int port;


	protected void setUpTestPort() {
		RestAssured.port = port;

	}

}
