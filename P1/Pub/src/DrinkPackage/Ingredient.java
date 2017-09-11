package DrinkPackage;

/*
 * package-private class
 * */
abstract class Ingredient {
	protected int _price;
	
	public int getPrice() {
		return this._price;
	}
	public void setPrice(int price) {
		this._price = price;
	}
}
