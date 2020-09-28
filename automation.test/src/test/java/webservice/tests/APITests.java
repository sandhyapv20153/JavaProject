package webservice.tests;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterTest;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APITests{
  WebService wService;
	
	@BeforeTest
	public void beforeTest() {
		this.wService = new WebService();

	}
  
  
	@Test
	@Parameters({"userNameValid"})
	public void apiValidStatusResponseTest(String userNameValid) {
		wService.SetUpRequest(userNameValid);
		wService.postRequest();
		wService.validateStatusCodeResponse();
	}
	
	@Test 
	@Parameters({"userNameValid"})
	public void apiSuccessfulResponseTest(String userNameValid) {
		wService.SetUpRequest(userNameValid);
		wService.postRequest();
		wService.parseResponse();
	}
	
	
	@Test 
	@Parameters({"userNameInvalid"})
	public void apiInvalidParameterTest(String userNameInvalid) {
		wService.SetUpRequest(userNameInvalid);
		wService.postRequest();
		wService.invalidParameterScenario();

	}

	@AfterTest 
	public void afterTest() {
	}

}
