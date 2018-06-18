
@time
Feature: Manage Time
  The purpose of this feature is to use create and get Time api


  @create-get-time
  Scenario Outline: Create and get time
    Given A getAll and a create time with <id>
    When I retrieve the time with <id> in step
    Then The system responses ok with <id>

    Examples: 
      | id  | 
      | "1" |     
      | "2" |     
