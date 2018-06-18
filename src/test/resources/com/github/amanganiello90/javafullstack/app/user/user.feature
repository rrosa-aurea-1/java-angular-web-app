
@user
Feature: Manage User
Description: The purpose of this feature is to use all user api

Background: User created
	Given An user with
	 | id |  email 									    | 
   | 1  |  amanganiello90@github.it   |
   | 2  |  amanganiello2@github.it    |
	
  Then I perform the create call and have users on db
   
  @get-user
  Scenario Outline: Get user
    Given An user with <id>
    When I perform the get call
    Then I have the user with <email>

    Examples: 
      | id |  email 										 | 
      | "1"|  "amanganiello90@github.it" |
      | "2"|  "amanganiello2@github.it"  |
      
  
  @delete-user
  Scenario Outline: Delete user
    Given An user with <id>
    When I perform the delete call
    Then I have the user deleted

    Examples: 
      | id |  email 										 | 
      | "1"|  "amanganiello90@github.it" |
      | "2"|  "amanganiello2@github.it"  |
       
      
  @update-user
  Scenario Outline: update user
    Given An user with <id> and <email>
    When I perform the update call with <new-email>
    Then I have the user updated with the new <new-email>

    Examples: 
      | id   |  email 								     | new-email    |
      | "1"  |  "amanganiello90@github.it" | "my1@email"  |
      | "2"  |  "amanganiello2@github.it"  | "my21@email" |
     
  
