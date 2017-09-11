package DrinkPackage;

public class BacardiSpecial implements Drink {

	public BacardiSpecial() {
	}
	
	@Override
	public int getPrice() {
		Ingredient ing1 = new Ingredient1();
		Ingredient ing2 = new Ingredient2();
		Ingredient ing3 = new Ingredient3();
		Ingredient ing6 = new Ingredient6();
		
		return ing1.getPrice() + ing2.getPrice() + ing3.getPrice() + ing6.getPrice();
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
