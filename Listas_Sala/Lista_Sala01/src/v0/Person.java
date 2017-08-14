package v0;

public class Person {
	// Static variables
	private static int nextId=0;
	
	public Person(){
		_id = nextId++;
	}
	   
	public int getId() {
	  return _id;
	}
	
	// Variables of the class
	private int _id;
}
