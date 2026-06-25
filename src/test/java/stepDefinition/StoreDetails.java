package stepDefinition;

import endPoints.PetStore;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payloads.PetOrder;

public class StoreDetails {
	
	RequestSpecification request;
	Response response;
	PetOrder order;
	static int orderId;

	@Given("User is in Pet Store page")
	public void user_is_in_pet_store_page() {
		RestAssured.useRelaxedHTTPSValidation();
	}
	
	@When("Get inventory Details")
	public void get_inventory_details() {
		response = RestAssured.when().get(PetStore.inventoryDetails);
	}

	@Then("Validate inventory details")
	public void validate_inventory_details() {
		response.then().statusCode(200);
		response.prettyPrint();
	}
	
	@Given("User has all details of petorder")
	public void user_has_all_details_of_petorder() {
		order = new PetOrder();
		order.setId(101);
		order.setPetId(1045);
		order.setQuantity(1);
		order.setShipDate("2026-06-22T14:52:57.059+0000");
		order.setStatus("delivered");
		order.setComplete(true);
		
		request = RestAssured.given().header("Content-Type", "application/json").body(order);
	}

	@When("user place order")
	public void user_place_order() {
		response = request.when().post(PetStore.postOrder);
	}

	@Then("Validate schema of place order")
	public void validate_schema_of_place_order() {
		response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("Schemas/NewOrder.json"));
		response.then().statusCode(200);
		orderId = response.jsonPath().get("id");
	}

	@Given("User has placed orderId")
	public void user_has_placed_order_id() {
	request = RestAssured.given().pathParam("orderID", orderId);
	}
	
	@When("get orderId")
	public void get_order_id() {
		response = request.when().get(PetStore.OrderId);
	}

	@Then("Validate orderId status")
	public void validate_order_id_status() {
		response.then().statusCode(200);
	}

}
