package v0;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import v0.Person;
import v0.Project;

public class v0Test {
	private Person[] ps = new Person[3];
	Project pj = new Project();
	
	@Before
	public void setUp() {
		for (int i = 0; i < ps.length; i++) {
			ps[i] = new Person();
			pj.addParticipant(ps[i]);
		}
		//pj.printParticipants();
	}

	@Test
	public void test() {
		Person x = new Person();
		assertTrue(!pj.hasMember(x));
		
		Person p = ps[1];
		assertTrue(pj.hasMember(p));
		
		pj.removeParticipant(p);
		assertTrue(!pj.hasMember(p));
	}

}
