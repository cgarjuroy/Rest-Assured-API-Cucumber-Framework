package payloads;

import com.github.javafaker.Faker;

public class User_Payload {
	
	Faker faker;
	
	//Properties
	private int	id;
	private String userName;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int phone;
	private int status;
	
	//Constructors
	public User_Payload() {
		super();
	}

	//Getter and Setter
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	public void baseMethod() {
		faker = new Faker();
		setId(faker.idNumber().hashCode());
		setUserName(faker.name().username());
		setFirstName(faker.name().firstName());
		setLastName(faker.name().lastName());
		setEmail(faker.internet().safeEmailAddress());
		setPassword(faker.internet().password(5,10));
		setStatus(faker.number().numberBetween(0, 10));
	}
	
	
}
