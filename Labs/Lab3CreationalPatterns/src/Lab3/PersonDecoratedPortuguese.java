package Lab3;

public class PersonDecoratedPortuguese implements PersonDecorated {

	private String _decoratedName;
	private String _decoratedPhoneNumber;
	private String _decoratedAddress;
	
	private String decorateName(String name) {
		return "Sr. " + name;
	}
	
	private String decoratePhoneNumber(String phoneNumber) {
		return "+55 " + phoneNumber;
	}
	
	private String decorateAddress(String address){
		return "Rua " + address;
	}
	
	public PersonDecoratedPortuguese(Person person, Address address) {
		_decoratedName = decorateName(person.getName());
		person.setDecoratedName(_decoratedName);
		_decoratedPhoneNumber = decoratePhoneNumber(person.getPhone());
		person.setDecoratedPhoneNumber(_decoratedPhoneNumber);
		_decoratedAddress = decorateAddress(address.getName());
		address.setDecoratedName(_decoratedAddress);
	}
	
	public String getName() {
		return _decoratedName;
	}
	
	public String getAddress() {
		return _decoratedAddress;
	}
	
	public String getPhoneNumber() {
		return _decoratedPhoneNumber;
	}
}
