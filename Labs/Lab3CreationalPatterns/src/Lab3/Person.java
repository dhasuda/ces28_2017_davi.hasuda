package Lab3;

public class Person {
	private String name;
	private String phone;
	private String email;
	
	public Person(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getPhone() {
		return this.phone;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public void setDecoratedName(String decoratedName) {
		this.name = decoratedName;
	}

	public void setDecoratedPhoneNumber(String decoratedPhoneNumber) {
		this.phone = decoratedPhoneNumber;
	}
	
}
