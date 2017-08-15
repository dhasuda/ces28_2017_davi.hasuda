package lab1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;



public class lab1Tests {
	private Money m12CHF;
    private Money m14CHF;
    private Money m14BRL;
    private Currency USD;
    private Currency BRL;
    private Currency CHF;

    @Before
    public void setUp() {
        USD = new Currency("USD");
        BRL = new Currency("BRL");
        CHF = new Currency("CHF");

        m12CHF = new Money(CHF);
        m12CHF.setAmount(12);
        //m12CHF.setCurrency("CHF");

        m14CHF = new Money(CHF);
        m14CHF.setAmount(14);
        //m14CHF.setCurrency("CHF");

        m14BRL = new Money(BRL);
        m14BRL.setAmount(14);
        //m14BRL.setCurrency("BRL");
    }

    @Test
    public void addTest() {
        Money expected = new Money(CHF);
        //expected.setCurrency("CHF");
        expected.setAmount(12);
        assertTrue(expected.getAmount() == 12);
        assertTrue(expected.getCurrency().equals(CHF));

        expected = new Money(BRL);
        //expected.setCurrency("BRL");
        expected.setAmount(12378590);
        assertTrue(expected.getCurrency().equals(BRL));
        assertTrue(expected.getAmount() == 12378590);
    }

    @Test
    public void addTestEquals() {
        Money newMoney = new Money(CHF);
        newMoney.setAmount(12);
        //newMoney.setCurrency("CHF");

        assertEquals(newMoney, m12CHF);

        newMoney.setAmount(14);
        assertEquals(newMoney, m14CHF);

        newMoney.setCurrency(BRL);
        assertEquals(newMoney, m14BRL);
    }
     // Nahum
    @Test
    public void emptyMoneyBag() {
    	
    }
    // Nahum    
    @Test
    public void addMoneyToMoneyBag() {
    		
    }
    // Nahum
    @Test
    public void removeFromMoneyBag() {
    	
    }
    
    
    // Davi
    @Test
    public void findMoneyInMoneyBag() {
    		MoneyBag mb = new MoneyBag();
    		mb.add(m12CHF);
    		mb.add(m14BRL);
    		
    		assertEquals(m14BRL, mb.findMoney(BRL));
    		
    		mb.add(m14CHF);
    		Money expected = new Money(CHF);
    		expected.setAmount(26);
    		assertEquals(expected, mb.findMoney(CHF));
    }
    
    // Davi    
    @Test
    public void containsMoneyInMoneyBag() {
    		MoneyBag mb = new MoneyBag();
    		mb.add(m12CHF);
    		mb.add(m14BRL);
    		
    		assertTrue(mb.contains(m14BRL));
    		assertFalse(mb.contains(m14CHF));
    		
    		mb.add(m14CHF);
    		Money expected = new Money(CHF);
    		expected.setAmount(26);
    		assertTrue(mb.contains(expected));
    }
    
    @Test
    public void addMoneyToMoney() {
    		Money newMoney = new Money(CHF);
    		newMoney.setAmount(18);
    		
    		Money expectedMoney = new Money(CHF);
    		expectedMoney.setAmount(30);
    		assertEquals(newMoney.add(m12CHF), expectedMoney);
    		
    		MoneyBag expectedMoneyBag = new MoneyBag();
    		expectedMoneyBag.add(m12CHF);
    		newMoney.setCurrency(BRL);
    		expectedMoneyBag.add(newMoney);
    		
    		assertEquals(expectedMoneyBag, newMoney.add(m12CHF));
    		
    }

    @Test
    public void valueInBRLTest() {
        Money newUSDMoney = new Money(USD);
        Money newBRLMoney = new Money(BRL);
        Money newCHFMoney = new Money(CHF);
        newUSDMoney.setAmount(30);
        newBRLMoney.setAmount(10);
        newCHFMoney.setAmount(20);

        MoneyBag newMoneyBag = new MoneyBag();
        newMoneyBag.add(newUSDMoney);
        newMoneyBag.add(newBRLMoney);
        newMoneyBag.add(newCHFMoney);
        assertEquals(newMoneyBag.totalValueInBRL(), 140);
    }

}
