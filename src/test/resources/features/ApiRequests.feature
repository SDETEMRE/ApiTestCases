
@apiTest


Feature: Confirm API Requests for Wikimedia works as expected

  Scenario: First Scenario
    Given A client of the API
    When A search for pages containing for "furry rabbits" is executed
    Then A page with the title "Sesame Street" is found


  Scenario: Second Scenario
    Given The result for "furry rabbits" search contains "Sesame Street"
    When The page details for "Sesame Street" are requested
    Then It has a latest timestamp