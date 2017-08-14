package v0;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Project {
	 
	
	private Set<Person> participants = new HashSet<Person>();
	  
	public Set<Person> getParticipants() { return Collections.unmodifiableSet(participants); }
	
	public int getNumberOfParticipants() { return participants.size(); }
	
	public void addParticipant(Person p) {
		participants.add(p);
	}
	
	public void removeParticipant(Person p) {
		participants.remove(p);
	}

	public void printParticipants() {
		for (Person p: participants)
			System.out.println("project has person "+ p.getId());
	}
	  
	public boolean hasMember(Person p) { // participate substitute
		return participants.contains(p);
	}
}

