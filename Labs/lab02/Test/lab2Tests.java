import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

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
		assertEquals(6, CalculadoraString.add("1,2,3"));
		assertEquals(6, CalculadoraString.add("1,2 3"));
		assertEquals(10, CalculadoraString.add("1 ,  2  3 ,  4"));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void test1b() throws IllegalArgumentException{
		 CalculadoraString.add("X");
	}
	@Test(expected = IllegalArgumentException.class)
	public void test1c() throws IllegalArgumentException{
		 CalculadoraString.add("1,X");
	}

	@Test
	public void test2() {
		assertEquals(0, CalculadoraString.add(" "));
		assertEquals(0, CalculadoraString.add(","));
		assertEquals(0, CalculadoraString.add(",, ,"));
		assertEquals(1, CalculadoraString.add("1,,"));
		assertEquals(10, CalculadoraString.add(", ,1 ,  2  3 ,  ,4,,,"));
	}
	
	@Test
	public void test3() {
		assertEquals(1, CalculadoraString.add("1,\n"));
		assertEquals(3, CalculadoraString.add("1\n2"));
	}
	
	@Test
	public void test4() {
		assertEquals(3, CalculadoraString.add("//[;]\n1;2"));
		assertEquals(10, CalculadoraString.add("//[;]\n1;2,3\n4"));
		assertEquals(3, CalculadoraString.add("//[ ]\n1 2"));
	}
	
	@Rule
	public ExpectedException exceptionExpected = ExpectedException.none();
	
	@Test
	public void test5a() {
		exceptionExpected.expect(IllegalArgumentException.class);
		exceptionExpected.expectMessage("negativos proibidos [-1]");
		CalculadoraString.add("-1");
	}
	
	@Test
	public void test5b() {
		exceptionExpected.expect(IllegalArgumentException.class);
		exceptionExpected.expectMessage("negativos proibidos [-1 -2]");
		CalculadoraString.add("-1, -2");
	}
	
	@Test
	public void test5c() {
		exceptionExpected.expect(IllegalArgumentException.class);
		exceptionExpected.expectMessage("negativos proibidos [-2 -3 -4]");
		CalculadoraString.add("//[;]\n1;-2,-3\n-4");
	}
	
	@Test
	public void test6() {
		assertEquals(2, CalculadoraString.add("2,1001"));
		assertEquals(3, CalculadoraString.add("1, 2000, 2, 3000"));
	}
	
	@Test
	public void test7a() {
		assertEquals(6, CalculadoraString.add("//[***]\n1***2***3"));
		assertEquals(10, CalculadoraString.add("//[***]\n1***2,3\n4"));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void test7b() {
		assertEquals(6, CalculadoraString.add("//[***]\n1***2*3"));
	}
	
	@Test
	public void test7c() {
		assertEquals(6, CalculadoraString.add("//[*]\n1***2*3"));
	}
	
	@Test
	public void test8() {
		assertEquals(6, CalculadoraString.add("//[*][%]\n1*2%3"));
		assertEquals(15, CalculadoraString.add("//[*][%]\n1*2%3\n4,5"));
	}
	
	@Test
	public void test9a() {
		assertEquals(6, CalculadoraString.add("//[***][%%]\n1***2%%3"));
		assertEquals(15, CalculadoraString.add("//[***][%%]\n1***2%%3\n4,5"));
	}
	
	@Test
	public void test9b() {
		assertEquals(6, CalculadoraString.add("//[***][%%]\n1***2%%***%%%%3"));
		assertEquals(15, CalculadoraString.add("//[***][%%]\n1***2%%3\n4,5"));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void test9c() {
		assertEquals(6, CalculadoraString.add("//[***][%%]\n1***2%%%***%%%%3"));
	}
	
	@Test (expected=IllegalArgumentException.class)
	public void test9d() {
		assertEquals(15, CalculadoraString.add("//[***][%%]\n1***2%%;3\n4,5"));
	}
	
}
