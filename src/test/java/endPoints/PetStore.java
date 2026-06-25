package endPoints;

public class PetStore {
	
	public static String baseURL = "https://petstore.swagger.io/v2";
	
	//PetStore order details
	public static String inventoryDetails = baseURL+"/store/inventory";
	public static String postOrder = baseURL+"/store/order";
	public static String OrderId = baseURL+"/store/order/{orderID}";
	 
	//Pet Details
	public static String allPetDetails = baseURL+"/pet/findByStatus";
	public static String newPet = baseURL+"/pet";
	public static String petID = baseURL+"/pet/{id}";
	
}
