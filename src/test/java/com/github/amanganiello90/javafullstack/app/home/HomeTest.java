package com.github.amanganiello90.javafullstack.app.home;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 *
 * @author amanganiello90 Api automatic integration tests with rest assured and
 *         cucumber
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "pretty", "html:target/cucumber" })
public class HomeTest {

}
