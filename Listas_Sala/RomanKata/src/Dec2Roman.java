
import java.util.LinkedHashMap;



public class Dec2Roman {

	// esta indirecao extra so para poder trocar as versoes facil!
	// troque conv0 por conv1, conv2, conv10, etc. 
	// assim voce pode manter as versoes como metodos da mesma classe.
	public static String conv(int num) {
		return conv12(num);
	}
	
	// 1 {} -> null
	public static String conv0(int num) {
		return null; 	// version 0: no test passes.
	}
	
	// next iteration: one test passes
	// 2 nil -> constant
	public static String conv1(int num) {
		return "I";
	}
	
	/*********************************************************/
	// 3rd iteration: 2 tests pass
	// 4 Constant -> variable
	// 5 statement -> statements
	// 6 unconditional -> conditional
	public static String conv2(int num) {
		
		 String res = "I";

	     if (num > 1)
	        {
	            res += "I";
	        }
	     
	     return res;
	}
	
	public static String conv3(int num) {
		String res = "";
		for (int i=0; i<num; i++) {
			res += "I";
		}
		return res;
	}
	
	public static String conv4(int num) {
		String res = "";
		if (num < 4) {
			for (int i=0; i<num; i++) {
				res += "I";
			}
		}
		else {
			res = "IV";
		}
		return res;
	}
	
	public static String conv5(int num) {
		String res = "";
		if (num < 4) {
			for (int i=0; i<num; i++) {
				res += "I";
			}
		}
		else if (num == 4) {
			res = "IV";
		}
		else {
			res = "V";
		}
		return res;
	}
	
	public static String conv6(int num) {
		String res = "";
		if (num < 4) {
			res += addIs(num);
		}
		else if (num == 4) {
			res = "IV";
		}
		else {
			res = "V";
			num -= 5;
			res += addIs(num);
		}
		return res;
	}
	
	// Aux function
	private static String addIs(int n) {
		String res = "";
		if (n < 4) {
			for (int i = 0; i < n; i++) {
				res += "I";
			}
		}
		return res;
	}
	
	public static String conv7(int num) {
		String res = "";
		if (num < 4) {
			res += addIs(num);
		}
		else if (num == 4) {
			res = "IV";
		}
		else if (num < 9) {
			res = "V";
			num -= 5;
			res += addIs(num);
		}
		else if (num == 9) {
			res = "IX";
		}
		else {
			res = "X";
		}
		return res;
	}
	
	public static String conv8(int num) {
		String res = "";
		if (num < 4) {
			res += addRepetitive(num, "I");
		}
		else if (num == 4) {
			res = "IV";
		}
		else if (num < 9) {
			res = "V";
			num -= 5;
			res += addRepetitive(num, "I");
		}
		else if (num == 9) {
			res = "IX";
		}
		else {
			res += addRepetitive(num/10, "X");
			num = num%10;
			res += conv8(num);
		}
		return res;
	}
	
	// Aux function
	private static String addRepetitive(int times, String letter) {
		String res = "";
		for (int i=0; i<times; i++) {
			res += letter;
		}
		return res;
	}
	
	public static String conv9(int num) {
		String res = "";
		LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
		Results.put(1,"I");
    		Results.put(5,"V");
    		Results.put(10, "X");
    		Results.put(50, "L");
    		
    		if (num <= 3) {
    			res += addRepetitiveLimited(num, Results.get(1), "");
    		}
    		else if (num <= 5) {
    			res += addRepetitiveLimited(num, Results.get(5), Results.get(1));
    		}
    		else if (num < 9) {
    			res = "V";
    			num -= 5;
    			res += addRepetitiveLimited(num, Results.get(1), "");
    		}
    		else if (num == 9) {
    			res = "IX";
    		}
    		else if (num < 40) {
    			res += addRepetitiveLimited(num/10, Results.get(10), Results.get(1));
    			num = num%10;
    			res += conv9(num);
    		}
    		else {
    			res += addRepetitiveLimited(num/10, Results.get(50), Results.get(10));
    			num = num%10;
    			res += conv9(num);
    		}
		return res;
	}
	
	// Aux function
		private static String addRepetitiveLimited(int times, String letter, String previousLetter) {
			String res = "";
			if (times <= 3) {
				for (int i=0; i<times; i++) {
					res += letter;
				}
			}
			else if (times == 4) {
				res += previousLetter;
				res += letter;
			}
			else {
				res = letter;
			}
			return res;
		}
		
		public static String conv10(int num) {
			String res = "";
			LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
			Results.put(1,"I");
	    		Results.put(5,"V");
	    		Results.put(10, "X");
	    		Results.put(50, "L");
	    		Results.put(100, "C");
	    		
	    		if (num >= 100) {
	    			res += addRepetitive10(num/100, Results.get(100), "");
	    			num = num%100;
	    			res += conv10(num);
	    		}
	    		else if (num >= 10) {
	    			if (num/10 == 9) {
	    				res += Results.get(10) + Results.get(100);
	    				num -= 90;
	    			}
	    			
	    			res += addRepetitive10(num/10, Results.get(10), Results.get(50));
	    			num = num%10;
	    			res += conv10(num);
	    		}
	    		else {
	    			if (num == 9) {
	    				res += Results.get(1) + Results.get(10);
	    				num -= 9;
	    			}
	    			
	    			res += addRepetitive10(num, Results.get(1), Results.get(5));
	    		}
	    		return res;
		}
		
		static String addRepetitive10(int n, String letter, String secondary) { // 0 <= n <= 8
			String res = "";
			if (n <= 3) {
				for (int i=0; i < n; i++) {
					res += letter;
				}
			}
			else if (n == 4) {
				res = letter + secondary;
			}
			else {
				res = secondary;
				n -= 5;
				res += addRepetitive10(n, letter, secondary);
			}
			return res;
		}
		
		public static String conv11(int num) {
			String res = "";
			LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
			Results.put(1,"I");
	    		Results.put(5,"V");
	    		Results.put(10, "X");
	    		Results.put(50, "L");
	    		Results.put(100, "C");
	    		Results.put(500, "D");
	    		
	    		if (num >= 100) {
	    			if (num/100 == 9) {
	    				res += Results.get(100) + "";
	    				num -= 900;
	    			}
	    			
	    			res += addRepetitive10(num/100, Results.get(100), Results.get(500));
	    			num = num%100;
	    			res += conv10(num);
	    		}
	    		else if (num >= 10) {
	    			if (num/10 == 9) {
	    				res += Results.get(10) + Results.get(100);
	    				num -= 90;
	    			}
	    			
	    			res += addRepetitive10(num/10, Results.get(10), Results.get(50));
	    			num = num%10;
	    			res += conv10(num);
	    		}
	    		else {
	    			if (num == 9) {
	    				res += Results.get(1) + Results.get(10);
	    				num -= 9;
	    			}
	    			
	    			res += addRepetitive10(num, Results.get(1), Results.get(5));
	    		}
	    		return res;
		}
		
		public static String conv12(int num) {
			String res = "";
			LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
			Results.put(1,"I");
	    		Results.put(5,"V");
	    		Results.put(10, "X");
	    		Results.put(50, "L");
	    		Results.put(100, "C");
	    		Results.put(500, "D");
	    		Results.put(1000, "M");
	    		Results.put(5000, "");

	    		
	    		int aux = 3;
	    		while (aux >= 0) {
	    			int power = (int)Math.pow(10, aux);
	    			if (num >= power) {
	    				if (num/power == 9) {
		    				res += Results.get(power) + Results.get(power*10);
		    				num -= 9*power;
		    			}
	    				res += addRepetitive10(num/power, Results.get(power), Results.get(power*5));
	    				num = num%power;
	    			}
	    			aux --;
	    		}
	    		
	    		return res;
		}
		
		
		

}// class Dec2Roman
	
	/*
	/// EXAMPLE OF HOW TO USE A DICTIONARY!
	// example of how to use a dictionary to avoid repetition
	public static String conv4_2(int number)
	    {
	    	LinkedHashMap<Integer, String> Results = new LinkedHashMap<Integer, String>();
	    	Results.put(1,"I");
	    	Results.put(4,"IV");
	    	
	        if (Results.containsKey(number) )
	        {
	            return Results.get(number);
	        }
	        return Results.get(1) + conv4_2(number - 1);
	    }
	*/


	
		

