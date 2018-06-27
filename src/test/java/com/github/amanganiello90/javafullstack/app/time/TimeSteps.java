package com.github.amanganiello90.javafullstack.app.time;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.github.amanganiello90.javafullstack.app.JavaFullStackRunner;
import com.github.amanganiello90.javafullstack.app.models.SimpleTime;
import com.jayway.restassured.response.Response;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.github.amanganiello90.javafullstack.app.ConfigTest;

@SpringApplicationConfiguration(classes = JavaFullStackRunner.class)
public class TimeSteps extends ConfigTest {

	final String timesEndpoint = "/api/times/";
	Response findCreate;

	@Autowired
	protected SimpleTime simpleTime;

	@Given("^A getAll and a create time with \"([^\"]*)\"$")
	public void i_create_a_time_with(String id) throws Throwable {
		super.setUpTestPort();
		
		given().when().get(timesEndpoint).then().statusCode(HttpStatus.SC_OK);
		Response resCreate = given().when().get(timesEndpoint + id);

		resCreate.then().statusCode(HttpStatus.SC_OK);

	}

	@When("^I retrieve the time with \"([^\"]*)\" in step$")
	public void i_retrieve_the_time_with_in_step(String id) throws Throwable {
		findCreate = given().when().get(timesEndpoint + "find/" + id);
		

	}

	@Then("^The system responses ok with \"([^\"]*)\"$")
	public void the_system_responses_ok_with_in(String id) throws Throwable {
		findCreate.then().statusCode(HttpStatus.SC_OK);
		assertFalse(findCreate.getBody().asString().isEmpty());
		SimpleTime time = findCreate.as(simpleTime.getClass());

		assertTrue(time.getId().equals(id));

	}

}
