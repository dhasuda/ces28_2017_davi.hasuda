package DrinkPackage;

public class Beer implements Drink {

	public Beer() {
	}
	
	@Override
	public int getPrice() {
		return 74;
	}

	@Override
	public boolean isLimited() {
		return false;
	}

	@Override
	public boolean hasStudentDiscount() {
		return true;
	}

}
