package com.github.amanganiello90.javafullstack.app.user;


import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions( plugin = {"pretty", "html:target/cucumber"})
public class UserTest {
	

}
