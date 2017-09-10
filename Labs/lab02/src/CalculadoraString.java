import java.util.HashSet;
import java.util.Set;

public class CalculadoraString {
	
	/*
	 * Main method to be implemented for this lab
	 * */
	static public int add(String s) throws IllegalArgumentException {
		// Checking for new delimiters
		Set<String> delimiters = new HashSet<String>();
		try {
			if (s.substring(0, 3).compareTo("//[") == 0) {
				s = s.substring(2);
				while (s.charAt(0) == '[') {
					if (s.indexOf("]") > 0)
					{
						int lastIndexDelimeter = s.indexOf("]");
						if (lastIndexDelimeter > 1) {
							String newDelimeter = s.substring(1, lastIndexDelimeter);
							delimiters.add(newDelimeter);
							s = s.substring(lastIndexDelimeter + 1);
						} else {
							// Blank delimiter
							throw new IllegalArgumentException();
						}
					} else {
						// Doesn't have a closing "]" for some delimiter definition
						throw new IllegalArgumentException();
					}
				}
				s = s.substring(1); // Advances to next character
			}
		} catch (IndexOutOfBoundsException e) {
			// In case substring(0,3) is greater than the string's own size
			// Do nothing
		}
		
		s = s.replaceAll("\n", ",");
		s = s.replaceAll(" ", ",");
		for (String delim: delimiters) {
			s = s.replace(delim, ",");
		}
		
		int answer;
		try {
			answer = addRecursive(s);
		} catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			msg = "negativos proibidos " + msg;
			throw new IllegalArgumentException(msg);
		}
		return answer;
	}
	
	static private int addRecursive(String s) throws IllegalArgumentException {
		if (s.isEmpty()) { // Empty string returns 0
			return 0;
		}
		
		// If string is not empty
		String firstSubstring = "";
		String secondSubstring = "";
		
		int separatorIndex = s.indexOf(",");
		
		if (separatorIndex == -1) { // There is no separator in the string
			firstSubstring = s;
		}
		else { // There is a comma in the string
			firstSubstring = s.substring(0, separatorIndex);
			if (separatorIndex < s.length()-1) { // Separator is not the last character in the string
				secondSubstring = s.substring(separatorIndex+1);
			}
		}		
		
		int firstInt = 0;
		int secondInt = 0;
		try {
			if (!firstSubstring.isEmpty()) {
				try {
					firstInt = Integer.parseInt(firstSubstring);
				} catch(IllegalArgumentException e) {
					throw e;
				}
				
			}
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException();
		}
		try {
			secondInt = addRecursive(secondSubstring);
		} catch (IllegalArgumentException e) {
			String msg = e.getMessage();
			if (firstInt < 0) {
				if (msg.isEmpty()) {
					msg = "[" + Integer.toString(firstInt) + "]";
				} else {
					msg = "[" + Integer.toString(firstInt) + " " + msg.substring(1);
				}
				IllegalArgumentException newException = new IllegalArgumentException(msg);
				throw newException;
			}
			else {
				throw e;
			}
		}
		
		if (firstInt < 0) {
			String msg = "[" + Integer.toString(firstInt) + "]";
			IllegalArgumentException e = new IllegalArgumentException(msg);
			throw e;
		}
		else if (firstInt > 1000) {
			firstInt = 0;
		}
		
		return firstInt + secondInt;
	}
	
}