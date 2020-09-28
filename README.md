## Pre-requisites:
1.	Install Jdk11 and setup JAVA_HOME and path.
2.	Maven 3.6.2 was used to build and execute the project (https://maven.apache.org/download.cgi ). Setup M2_HOME and M2
3.	I have not included the chrome driver binary in the project, so please add chrome driver binary to automation.test\src\main\resources\drivers folder. ( Chrome driver - https://chromedriver.chromium.org/downloads ).

## To run the project:
1.	Navigate to automation.test in command prompt.
2.	Run mvn clean install from command prompt. This will launch the tests.

## General explanation about project:
1.	The test only runs in Chrome. However the code can be easily extended to use other browsers. 
2.	The project properties are defined in project.properties file.
3.	The project uses Java with Selenium WebDriver, Maven, TestNG, RestAssured.
4.	TestNG runs two tests:
* Functional – CreateAndValidateOfferTests – This one creates the account and validates the offer values. This first test in this creates the account and stores the user account values and offer values in json. The second test reads the values in the json, sign in to the site and validates the offer values.
* Functional – APITests – This one runs the 3 API tests.
