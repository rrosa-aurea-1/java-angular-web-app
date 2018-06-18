package com.github.amanganiello90.javafullstack.app.home;

import static com.jayway.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.amanganiello90.javafullstack.app.configTest;

/**
*
* @author amanganiello90
* Api automatic integration tests with rest assured
*/
@RunWith(SpringJUnit4ClassRunner.class)
public class HomeTest extends configTest {
	
	@Test
	public void runningAppWithRandomPortTest() {
		given().when().get("/welcome").then().statusCode(HttpStatus.SC_OK).body(Matchers.is("Hello World!"));

	}

}
