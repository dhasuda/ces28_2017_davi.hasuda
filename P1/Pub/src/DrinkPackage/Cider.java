package DrinkPackage;

public class Cider implements Drink {

	public Cider() {
	}
	
	@Override
	public int getPrice() {
		return 103;
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
