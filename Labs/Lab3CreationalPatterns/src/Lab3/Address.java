package Lab3;

public class Address {
	private String name;
	
	public Address(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDecoratedName(String decoratedAddressName) {
		this.name = decoratedAddressName;
	}
}
