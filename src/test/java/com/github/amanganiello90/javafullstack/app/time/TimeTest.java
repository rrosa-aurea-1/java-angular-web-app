package com.github.amanganiello90.javafullstack.app.time;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.http.HttpStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.amanganiello90.javafullstack.app.configTest;
import com.github.amanganiello90.javafullstack.app.models.SimpleTime;
import com.jayway.restassured.response.Response;

/**
 *
 * @author amanganiello90 Api automatic integration tests with rest assured
 */
@RunWith(SpringJUnit4ClassRunner.class)
public class TimeTest extends configTest {

	@Autowired
	protected SimpleTime simpleTime;

	@Test
	public void runningAppWithManageTimeDb() {

		final String timesEndpoint = "/api/times/";

		given().when().get(timesEndpoint).then().statusCode(HttpStatus.SC_OK);
		String id = "1";

		Response resCreate = given().when().get(timesEndpoint + id);

		resCreate.then().statusCode(HttpStatus.SC_OK);

		// System.out.println(resCreate.getBody().asString());

		Response findCreate = given().when().get(timesEndpoint + "find/" + id);
		findCreate.then().statusCode(HttpStatus.SC_OK);

		assertFalse(findCreate.getBody().asString().isEmpty());
		SimpleTime time = findCreate.as(simpleTime.getClass());

		assertTrue(time.getId().equals(id));

	}

}
