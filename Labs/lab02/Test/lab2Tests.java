import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class lab2Tests {
	
	@Before
	public void setUp() {
	}

	@Test
	public void test1a() {
		assertEquals(0, CalculadoraString.add(""));
		assertEquals(1, CalculadoraString.add("1"));
		assertEquals(3, CalculadoraString.add("1,2"));
		assertEquals(3, CalculadoraString.add("1, 2"));
		assertEquals(3, CalculadoraString.add("1 , 2"));
		assertEquals(3, CalculadoraString.add("   1 , 2"));
		assertEquals(3, CalculadoraString.add("01 , 002"));
		//assertEquals(6, CalculadoraString.add("1,2,3")); // Isso vale??
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test1b() throws IllegalArgumentException{
		int sum = CalculadoraString.add("X");
	}


	@Test
	public void test2() {
		assertEquals(0, CalculadoraString.add(" "));
		assertEquals(0, CalculadoraString.add(","));
		assertEquals(0, CalculadoraString.add(",, ,"));
		assertEquals(1, CalculadoraString.add("1,,"));
	}
	
	@Test
	public void test3() {
		assertEquals(1, CalculadoraString.add("1,\n"));
		assertEquals(3, CalculadoraString.add("1\n2"));
	}
	
	@Test
	public void test4() {
		assertEquals(3, CalculadoraString.add("//[;]\\n1;2"));
		assertEquals(10, CalculadoraString.add("//[;]\\n1;2,3\\n4")); // Isso vale?
		assertEquals(3, CalculadoraString.add("//[ ]\\n1 2"));
	}
	
	@Test
	public void test5() {
		// Não entendi
	}
	
	@Test
	public void test6() {
		assertEquals(2, CalculadoraString.add("2,1001"));
		assertEquals(3, CalculadoraString.add("1, 2000, 2, 3000"));
	}
	
	@Test
	public void test7() {
		assertEquals(6, CalculadoraString.add("//[***]\\n1***2***3"));
		assertEquals(10, CalculadoraString.add("//[***]\\n1***2,3\\n4"));
	}
	
	@Test
	public void test8() {
		assertEquals(6, CalculadoraString.add("//[*][%]\\n1*2%3"));
		assertEquals(15, CalculadoraString.add("//[*][%]\\n1*2%3\\n4,5"));
	}
	
	@Test
	public void test9() {
		assertEquals(6, CalculadoraString.add("//[***][%%]\\n1***2%%3"));
		assertEquals(15, CalculadoraString.add("//[***][%%]\\n1***2%%3\\n4,5"));
	}
}
