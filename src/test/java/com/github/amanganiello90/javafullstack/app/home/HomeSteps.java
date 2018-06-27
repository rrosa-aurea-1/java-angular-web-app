package com.github.amanganiello90.javafullstack.app.home;

import static com.jayway.restassured.RestAssured.given;

import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.github.amanganiello90.javafullstack.app.JavaFullStackRunner;
import com.github.amanganiello90.javafullstack.app.ConfigTest;
import com.jayway.restassured.response.Response;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SpringApplicationConfiguration(classes = JavaFullStackRunner.class)
public class HomeSteps extends ConfigTest {

	private Response response;

	@Given("^The application started with the used server\\.port value$")
	public void the_application_started_with_the_used_server_port_value() throws Throwable {
		// set rest assured port
		super.setUpTestPort();
	}

	@When("^I perform the get request on welcome page$")
	public void i_perform_the_get_request_on_welcome_page() throws Throwable {
		response = given().when().get("/welcome");

	}

	@Then("^It will return ok with match$")
	public void it_will_return_ok() throws Throwable {
		response.then().statusCode(HttpStatus.SC_OK).body(Matchers.is("Hello World!"));
	}

}
