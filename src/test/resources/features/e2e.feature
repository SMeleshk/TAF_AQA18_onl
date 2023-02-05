Feature: Main features Test

  Scenario Outline: Login test
    Given Browser is opened
    * Login Page is opened
    When User "<username>" with password "<password>" logged in
    Then Product page is opened
    Examples:
      | username      | password     |
      | standard_user | secret_sauce |
      | problem_user  | secret_sauce |


  Scenario: End-to-end test
    Given Browser is opened
    * Login Page is opened
    * Successful login
    When First product is added to cart
    * Switch to Cart
    * Checkout
    * Fill first name "1", last name "2" and zip "3"
    * Finish shopping
    Then Correct text about completion is displayed