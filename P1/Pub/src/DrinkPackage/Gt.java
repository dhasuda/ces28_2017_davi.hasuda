package DrinkPackage;

public class Gt implements Drink {

	public Gt() {
	}
	
	@Override
	public int getPrice() {
		Ingredient ing4 = new Ingredient4();
		Ingredient ing5 = new Ingredient5();
		Ingredient ing6 = new Ingredient6();
		
		return ing4.getPrice() + ing5.getPrice() + ing6.getPrice();
	}

	@Override
	public boolean isLimited() {
		return true;
	}

	@Override
	public boolean hasStudentDiscount() {
		return false;
	}

}
