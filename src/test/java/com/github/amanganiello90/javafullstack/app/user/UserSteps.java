package com.github.amanganiello90.javafullstack.app.user;

import static com.jayway.restassured.RestAssured.given;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.amanganiello90.javafullstack.app.JavaFullStackRunner;
import com.github.amanganiello90.javafullstack.app.ConfigTest;
import com.github.amanganiello90.javafullstack.app.models.User;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;

import cucumber.api.DataTable;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@SpringApplicationConfiguration(classes = JavaFullStackRunner.class)
public class UserSteps extends ConfigTest {

	private List<User> users;
	private User readUser;
	private final String createRequest = "/api/users";
	private String otherRequest;
	private ObjectMapper mapperObj = new ObjectMapper();

	@Autowired
	protected User user;

	// get user
	private User checkGetUser(String endpoint) {
		Response find = given().when().get(endpoint);
		find.then().statusCode(HttpStatus.SC_OK);

		if (find.getBody().asString().isEmpty()) {
			return null;
		}

		return find.as(user.getClass());

	}

	@Given("^An user with$")
	public void an_user_with(DataTable dataUsers) {

		// set rest assured port
		super.setUpTestPort();

		users = new ArrayList<>();
		for (int i = 1; i < dataUsers.raw().size(); i++) {
			User insertUser = user.factory();
			List<String> userFields = dataUsers.raw().get(i);
			insertUser.setId(userFields.get(0));
			insertUser.setEmail(userFields.get(1));
			users.add(insertUser);
		}

	}

	@Then("^I perform the create call and have users on db$")
	public void i_perform_the_create_call_and_have_users_on_db() throws JsonProcessingException {

		// create
		for (User insertUser : users) {
			given().contentType(ContentType.JSON).body(mapperObj.writeValueAsString(insertUser)).when()
					.post(createRequest).then().statusCode(HttpStatus.SC_OK);
		}
	}

	@Given("^An user with \"([^\"]*)\"$")
	public void an_user_with(String id) {
		otherRequest = createRequest + "/" + id;

	}

	@When("^I perform the get call$")
	public void i_perform_the_get_call() {
		// get
		readUser = this.checkGetUser(otherRequest);
	}

	@Then("^I have the user with \"([^\"]*)\"$")
	public void i_have_the_user_with(String email) {
		assertNotNull(readUser);

		assertTrue(readUser.getEmail().equals(email));

	}

	@Given("^An user with \"([^\"]*)\" and \"([^\"]*)\"$")
	public void an_user_with_and(String id, String email) {
		otherRequest = createRequest + "/" + id;
		readUser = this.checkGetUser(otherRequest);
		assertNotNull(readUser);
		assertTrue(readUser.getEmail().equals(email));

	}

	@When("^I perform the update call with \"([^\"]*)\"$")
	public void i_perform_the_update_call(String newEmail) throws JsonProcessingException {
		readUser.setEmail(newEmail);
		given().contentType(ContentType.JSON).body(mapperObj.writeValueAsString(readUser)).when().put(otherRequest)
				.then().statusCode(HttpStatus.SC_OK);

	}

	@Then("^I have the user updated with the new \"([^\"]*)\"$")
	public void i_have_the_user_updated_with_the_new_instead_of(String newEmail) {
		readUser = this.checkGetUser(otherRequest);
		assertNotNull(readUser);

		assertTrue(readUser.getEmail().equals(newEmail));

	}

	@When("^I perform the delete call$")
	public void i_perform_the_delete_call() {
		// get
		readUser = this.checkGetUser(otherRequest);
		// delete
		given().contentType(ContentType.JSON).body(readUser).when().delete(otherRequest).then()
				.statusCode(HttpStatus.SC_OK);

	}

	@Then("^I have the user deleted$")
	public void i_have_the_user_deleted() {
		readUser = this.checkGetUser(otherRequest);
		assertNull(readUser);

	}

}
