package stepDefinition;

import org.json.JSONObject;

import endPoints.PetStore;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.Pet_Payload;

public class PetDetails {
	
	RequestSpecification request;
	Response response;
	JSONObject json;
	static Pet_Payload payload;
	static long id;
	
	@Given("User want to access pet details")
	public void user_want_to_access_pet_details() {
		RestAssured.useRelaxedHTTPSValidation();
		request = RestAssured.given().queryParam("status", "available");
	}
	
	@When("Retrieve all pet details")
	public void retrieve_all_pet_details() {
	   response = request.when().get(PetStore.allPetDetails);
	}

	@Then("Validate details are correct")
	public void validate_details_are_correct() {
		response.then().statusCode(200);
		payload = response.jsonPath().getObject("find {it.name == 'Kukur'}", Pet_Payload.class);
	    
	}
	
	@Given("User has new pet details")
	public void user_has_new_pet_details() {
	    request = RestAssured.given().header("Content-Type","application/json").body(payload);
	}

	@When("User add new pet details")
	public void user_add_new_pet_details() {
	    response = request.when().post(PetStore.newPet);
	}

	@Then("Pet is successfully added")
	public void pet_is_successfully_added() {
	    response.then().statusCode(200);
	    response.then().assertThat()
	    .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/NewPet.json"));
	    Number numericID = response.jsonPath().get("id");
	    id = numericID.longValue();
	}

	@Given("User has added pet ID")
	public void user_has_added_pet_id() {
		request = RestAssured.given().pathParam("id", id);
	}
	@When("get details of added pet")
	public void get_details_of_added_pet() {
	    response = request.when().get(PetStore.petID);
	}

	@Then("Pet details should be displayed")
	public void pet_details_should_be_displayed() {
	    response.then().statusCode(200);
	}
}
