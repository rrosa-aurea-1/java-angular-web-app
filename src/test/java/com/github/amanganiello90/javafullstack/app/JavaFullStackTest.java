package com.github.amanganiello90.javafullstack.app;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.amanganiello90.javafullstack.app.JavaFullStackRunner;
import com.github.amanganiello90.javafullstack.app.models.User;
import com.github.amanganiello90.javafullstack.app.models.SimpleTime;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import static com.jayway.restassured.RestAssured.given;

/**
*
* @author amanganiello90
* Api automatic integration tests with restAssured
*/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = JavaFullStackRunner.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
@ActiveProfiles("mongo")
public class JavaFullStackTest {

	@Autowired
	User user;

	@Autowired
	SimpleTime simpleTime;

	@Value("${local.server.port}")
	int port;

	// get user
	private User checkGetUser(String endpoint) {
		Response find = given().when().get(endpoint);
		find.then().statusCode(HttpStatus.SC_OK);

		if (find.getBody().asString().isEmpty()) {
			return null;
		}
		

		return find.as(user.getClass());

	}

	@Before
	public void setUp() {

		RestAssured.port = port;
	}

	@Test
	public void runningAppWithRandomPortTest() {
		given().when().get("/welcome").then().statusCode(HttpStatus.SC_OK).body(Matchers.is("Hello World!"));

	}

	@Test
	public void runningAppWithManageTimeDb() {
		
		final String timesEndpoint="/api/times/";

		given().when().get(timesEndpoint).then().statusCode(HttpStatus.SC_OK);
		String id = "1";

		Response resCreate = given().when().get(timesEndpoint + id);

		resCreate.then().statusCode(HttpStatus.SC_OK);

		// System.out.println(resCreate.getBody().asString());

		Response findCreate = given().when().get(timesEndpoint+"find/" + id);
		findCreate.then().statusCode(HttpStatus.SC_OK);

		assertFalse(findCreate.getBody().asString().isEmpty());
		SimpleTime time = findCreate.as(simpleTime.getClass());

		assertTrue(time.getId().equals(id));

	}

	@Test
	public void runningAppWithManageUserDb() {

		User insertUser = user.factory();
		String id = "1";
		String email1 = "amanganiello@github.it";
		String email2 = "amanganiello90@github.it";
		final String createRequest = "/api/users";
		String otherRequest = createRequest + "/" + id;

		insertUser.setId(id);
		insertUser.setEmail(email1);

		// create
		given().contentType(ContentType.JSON).body(insertUser).when().post(createRequest).then()
				.statusCode(HttpStatus.SC_OK);

		User userRead = this.checkGetUser(otherRequest);
		assertNotNull(userRead);

		assertTrue(userRead.getEmail().equals(email1));

		// put
		insertUser.setEmail(email2);
		given().contentType(ContentType.JSON).body(insertUser).when().put(otherRequest).then()
				.statusCode(HttpStatus.SC_OK);

		userRead = this.checkGetUser(otherRequest);
		assertNotNull(userRead);

		assertTrue(userRead.getEmail().equals(email2));

		// delete
		given().contentType(ContentType.JSON).body(insertUser).when().delete(otherRequest).then()
				.statusCode(HttpStatus.SC_OK);

		userRead = this.checkGetUser(otherRequest);
		assertNull(userRead);

	}

}
