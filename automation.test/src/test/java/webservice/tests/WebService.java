package webservice.tests;

import static org.testng.Assert.assertEquals;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.Constants;
import main.PropertyFileUtility;
import main.Utilities;

public class WebService {
	String apiEndpoint;
	public static UUID UUIDValue;
	RequestSpecification httpRequest;
	Response response;
	
	
	public WebService() {
		this.apiEndpoint = PropertyFileUtility.readPropertyFile(Constants.PROJECT_PROPERTYFILE_PATH,"webserviceEndPoint");
		UUIDValue = Utilities.UUIDGenerator();
	}
	
	public void SetUpRequest(String userName)
	{
		RestAssured.baseURI = apiEndpoint;
		this.httpRequest = RestAssured.given();
		
		httpRequest.header("x-cf-source-id", "coding-challenge");
		httpRequest.header("x-cf-corr-id", UUIDValue);
		httpRequest.header("Content-Type", "application/json");
		
		JSONObject requestParameters = new JSONObject();
		requestParameters.put("username", userName);
		requestParameters.put("password", "On$3XcgsW#9q");
		httpRequest.body(requestParameters.toString());

		
	}
	
	public void postRequest()
	{
		this.response = httpRequest.post();
	}

	public void validateStatusCodeResponse()
	{
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		System.out.println("\nAPI Test 1: Actual status code : "+statusCode +" is same as expected status code of 200");

	}
	
	public void parseResponse()
	{
		//working...
		//JsonPath jPath = response.jsonPath();
		//System.out.println(jPath.get("firstName").toString());

		List<Map<String, String>> loans = response.jsonPath().getList("loansInReview");
		Iterator<Map<String, String>> itr= loans.iterator();
		Map<String,String> loanValues;
		while(itr.hasNext())
		{
			loanValues = (Map<String,String>)itr.next();
			if(loanValues.containsKey("productType"))
			{
				Assert.assertEquals(loanValues.get("productType"),"PERSONAL_LOAN");
				System.out.println("\nAPI Test 2: Actual product type : "+loanValues.get("productType") + " is equal to expected product type PERSONAL_LOAN" );
			}
		
		}
	}
	
	public void invalidParameterScenario()
	{
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 401);
		System.out.println("\nAPI Test 3: Actual status code : "+statusCode +" is same as expected status code of 401");
	}
}
