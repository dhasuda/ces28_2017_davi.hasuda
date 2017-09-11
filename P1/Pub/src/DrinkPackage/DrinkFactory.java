package DrinkPackage;

public class DrinkFactory {
	public DrinkFactory() {
	}
	
	public Drink getDrink(String name) {
		switch (name) {
		case "hansa":
			return new Beer();
		case "grans":
			return new Cider();
		case "strongbow":
			return new ProperCider();
		case "gt":
			return new Gt();
		case "bacardi_special":
			return  new BacardiSpecial();
			
		default:
			throw new RuntimeException("No such drink exists");
		}
	}
}
