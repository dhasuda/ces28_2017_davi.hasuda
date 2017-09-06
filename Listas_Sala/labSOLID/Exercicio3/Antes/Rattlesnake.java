package Antes;
import  java.lang.UnsupportedOperationException;

public class Rattlesnake extends Animal {
	public void feed() {
		// do something
	}
	public void groom() {
		throw new UnsupportedOperationException();
	}
}

