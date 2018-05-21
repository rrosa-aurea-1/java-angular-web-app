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
import com.github.amanganiello90.javafullstack.app.models.Product;
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
@ActiveProfiles("h2")
public class JavaFullStackTest {

	@Autowired
	Product product;

	@Autowired
	SimpleTime simpleTime;

	@Value("${local.server.port}")
	int port;

	// get product
	private Product checkGetProduct(String endpoint) {
		Response find = given().when().get(endpoint);
		find.then().statusCode(HttpStatus.SC_OK);

		if (find.getBody().asString().isEmpty()) {
			return null;
		}
		

		return find.as(product.getClass());

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

		given().when().get("/api/times").then().statusCode(HttpStatus.SC_OK);
		String id = "1";

		Response resCreate = given().when().get("/api/times/" + id);

		resCreate.then().statusCode(HttpStatus.SC_OK);

		// System.out.println(resCreate.getBody().asString());

		Response findCreate = given().when().get("/api/times/find/" + id);
		findCreate.then().statusCode(HttpStatus.SC_OK);

		assertFalse(findCreate.getBody().asString().isEmpty());
		SimpleTime time = findCreate.as(simpleTime.getClass());

		assertTrue(time.getId().equals(id));

	}

	@Test
	public void runningAppWithManageProductDb() {

		Product insertProd = product.factory();
		String id = "1";
		String prodDesc1 = "test1";
		String prodDesc2 = "test2";
		String createRequest = "/api/products";
		String otherRequest = createRequest + "/" + id;

		insertProd.setId(id);
		insertProd.setProdDesc(prodDesc1);

		// create
		given().contentType(ContentType.JSON).body(insertProd).when().post(createRequest).then()
				.statusCode(HttpStatus.SC_OK);

		Product productRead = this.checkGetProduct(otherRequest);
		assertNotNull(productRead);

		assertTrue(productRead.getProdDesc().equals(prodDesc1));

		// put
		insertProd.setProdDesc(prodDesc2);
		given().contentType(ContentType.JSON).body(insertProd).when().put(otherRequest).then()
				.statusCode(HttpStatus.SC_OK);

		productRead = this.checkGetProduct(otherRequest);
		assertNotNull(productRead);

		assertTrue(productRead.getProdDesc().equals(prodDesc2));

		// delete
		given().contentType(ContentType.JSON).body(insertProd).when().delete(otherRequest).then()
				.statusCode(HttpStatus.SC_OK);

		productRead = this.checkGetProduct(otherRequest);
		assertNull(productRead);

	}

}
