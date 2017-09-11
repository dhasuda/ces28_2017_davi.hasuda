package DrinkPackage;

public class ProperCider implements Drink {

	public ProperCider() {
	}
	
	@Override
	public int getPrice() {
		return 110;
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
