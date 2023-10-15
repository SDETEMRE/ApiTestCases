# Automation base

Automation Testing Using Java, RestAssured (API Test), Cucumber BDD and Allure reports.

Automation base is a behavior driven development (BDD) approach to write automation test script to test Web.  

The framework supports reporting with Allure reports.

#Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

Prerequisites
--------------
Maven
Java
Git

Installing
-------------
Clone the repo to get a working project


Running the tests - command line mode
-------------------
cd to project path  

mvn clean

mvn test

Running the tests - from IDE  
-------------------
Run [src/test/java/test/runners/CukesRunner.java] as maven test

Get Allure Report
-------------
mvn allure:serve
