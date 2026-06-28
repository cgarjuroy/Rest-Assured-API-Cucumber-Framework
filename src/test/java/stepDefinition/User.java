package stepDefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.User_Payload;

public class User {
	
	//properties
	private RequestSpecification request;
	private Response response;
	private static String userName;
	private static String passwrd;
	private static final int PORT = 8089;
	private static final String HOST = "http://localhost";
	

	@Given("User details are provided")
	public void user_details_are_provided() {
		//Setting up Wire-mock server
		RestAssured.baseURI = HOST;
		RestAssured.port = PORT;
		
		//Pay load setup
		User_Payload payload = new User_Payload();
		payload.baseMethod();
		userName = payload.getUserName();
		passwrd = payload.getPassword();
		
		//request setup
	    request = RestAssured.given().header("Content-Type", "application/json").body(payload);
	}

	@When("New User is created")
	public void new_user_is_created() {
		
		//HTTP request
	    response = request.when().post("/user");
	}

	@Then("Validate user is created successfully")
	public void validate_user_is_created_successfully() {
		
		//validation
	    String message = response.jsonPath().get("message").toString();
	    System.out.println(message);
	    Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Given("User has login credentials")
	public void user_has_login_credentials() {
		
		//Setting up Wire-mock server
		RestAssured.baseURI = HOST;
		RestAssured.port = PORT;
		
		//request setup with query parameters
	    request = RestAssured.given().queryParam("username", userName).queryParam("password", passwrd);
	}

	@When("User tries to login")
	public void user_tries_to_login() {
		
		//HTTP request
	    response = request.when().get("/user/login");
	}

	@Then("User will be able to login successfully")
	public void user_will_be_able_to_login_successfully() {
		
		//validations
	    Assert.assertEquals(response.statusCode(), 200);
	}
}
