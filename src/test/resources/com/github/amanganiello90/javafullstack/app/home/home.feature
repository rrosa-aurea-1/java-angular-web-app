
@app
Feature: App started
  I want to check if the app is started

  @homeUp
  Scenario: Check if the home is up
    Given The application started with the used server.port value
    When I perform the get request on welcome page
    Then It will return ok with match
  

  