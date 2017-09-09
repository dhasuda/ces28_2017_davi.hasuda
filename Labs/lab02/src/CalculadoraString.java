
public class CalculadoraString {
	
	/*
	 * Main method to be implemented for this lab
	 * */
	static public int add(String s) throws IllegalArgumentException {
		if (s.isEmpty()) { // Empty string returns 0
			return 0;
		}
		
		// If string is not empty
		String firstSubstring = "";
		String secondSubstring = "";
		
		int commaIndex = s.indexOf(",");
		
		if (commaIndex == -1) { // There is no comma in the string
			firstSubstring = s;
		}
		else { // There is a comma in the string
			firstSubstring = s.substring(0, commaIndex);
			if (commaIndex < s.length()-1) { // Comma is not the last character in the string
				secondSubstring = s.substring(commaIndex+1);
			}
		}
		// Removing all spaces from string
		firstSubstring = firstSubstring.replaceAll("\\s+","");
		secondSubstring = secondSubstring.replaceAll("\\s+","");
		
		int firstInt = 0;
		int secondInt = 0;
		try {
			if (firstSubstring.isEmpty()) {
				firstInt = 0;
			} else {
				firstInt = Integer.parseInt(firstSubstring);
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		try {
			secondInt = add(secondSubstring);
		} catch (IllegalArgumentException e) {
			throw e;
		}
		
		return firstInt + secondInt;
	}
}