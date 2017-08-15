import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;


//  ********* WHAT YOU HAVE TO DO *******
// dont change this test class
// edit Dec2Roman.java, to make these tests pass one by one.
//////////////////////////


public class Dec2RomanTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test1() {
		assertEquals("I",Dec2Roman.conv(1));
	} // test1
	
	@Test
	public void test2() {
		assertEquals("II",Dec2Roman.conv(2));
	} 

	@Test
	public void test3() {
		assertEquals("III",Dec2Roman.conv(3));
	}
	
	@Test
	public void test4() {
		assertEquals("IV",Dec2Roman.conv(4));
	}
	
	@Test
	public void test5() {
		assertEquals("V",Dec2Roman.conv(5));
	}
	
	@Test
	public void test8() {
		assertEquals("VI",Dec2Roman.conv(6));
		assertEquals("VII",Dec2Roman.conv(7));
		assertEquals("VIII",Dec2Roman.conv(8));
	}
	
	@Test
	public void test10() {
		assertEquals("IX",Dec2Roman.conv(9));
		assertEquals("X",Dec2Roman.conv(10));
	}
	
	@Test
	public void test14() {
		assertEquals("XII" ,Dec2Roman.conv(12));
		assertEquals("XIII",Dec2Roman.conv(13));
		assertEquals("XIV" ,Dec2Roman.conv(14));
	}
	
	@Test
	public void test44() {
		assertEquals("XXXIX",Dec2Roman.conv(39)); 
		assertEquals("XL",Dec2Roman.conv(40));  
		assertEquals("XLIV",Dec2Roman.conv(44));
	}
	
	@Test
	public void test100() {
		assertEquals("L",Dec2Roman.conv(50));
		assertEquals("LXX",Dec2Roman.conv(70));
		assertEquals("XC",Dec2Roman.conv(90));
		assertEquals("XCVIII",Dec2Roman.conv(98));
		assertEquals("XCIX",Dec2Roman.conv(99));
		assertEquals("C",Dec2Roman.conv(100));
	}
	
	@Test
	public void test100s() { 
		assertEquals("CLXVIII",Dec2Roman.conv(168));
		assertEquals("CCXCIX",Dec2Roman.conv(299));
		assertEquals("CDXLIX",Dec2Roman.conv(449));
	}
	
	@Test
	public void test2008() {
		assertEquals("CM",Dec2Roman.conv(900));
		assertEquals("M",Dec2Roman.conv(1000));
		assertEquals("DCCCXLVI",Dec2Roman.conv(846));
		assertEquals("MCMXCIX",Dec2Roman.conv(1999));
		assertEquals("MMVIII",Dec2Roman.conv(2008));
	}
	

}//class Dec2RomanTest
