package payloads;

public class PetOrder {
	
	//Properties
	private int id;
	private int petId;
	private int quantity;
	private String shipDate;
	private String status;
	private boolean complete;
	
	//Constructors
	public PetOrder() {super();}
	
	//Getter and Setters
	public int 	getId() 						{return id;}
	public void setId(int id) 					{this.id = id;}
	public int 	getPetId() 						{return petId;}
	public void setPetId(long petId) 			{this.petId = (int) petId;}
	public int getQuantity() 					{return quantity;}
	public void setQuantity(int quantity) 		{this.quantity = quantity;}
	public String getShipDate() 				{return shipDate;}
	public void setShipDate(String shipDate)	{this.shipDate = shipDate;}
	public String getStatus() 					{return status;}
	public void setStatus(String status)		{this.status = status;}
	public boolean isComplete() 				{return complete;}
	public void setComplete(boolean complete)	{this.complete = complete;}	
	
}
