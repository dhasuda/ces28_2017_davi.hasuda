package Q1.pubV0;

import DrinkPackage.Drink;
import DrinkPackage.DrinkFactory;

public class Pub {

    public int computeCost(String drink, boolean student, int amount) {
    		
    		Drink drinkOrder;
    	
    		DrinkFactory factory = new DrinkFactory();
    		try {
    			drinkOrder = factory.getDrink(drink);
    		} catch (RuntimeException e) {
    			throw e;
    		}
    		
    		if (amount > 2 && drinkOrder.isLimited()) {
    			throw new RuntimeException("Too many drinks, max 2.");
    		}
    		int price = drinkOrder.getPrice();
    		if (student && drinkOrder.hasStudentDiscount()) {
              price = price - price/10;
          }
    		
    		return price * amount;
    }
}
