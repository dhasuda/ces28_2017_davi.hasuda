package mvc;

import view.PersonDetailView;
//import view.PersonDetailViewListener;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
//import org.mockito.Mockito;

import controller.PersonDetailControllerImpl;
import model.Person;

public class Item4 {

	@Test
	public void test() {
		Person p = new Person("Rhuan");
		// Fazer o teste com PersonDetailViewListener no lugar da view
		PersonDetailView view = mock(PersonDetailView.class);
		PersonDetailControllerImpl controller = new PersonDetailControllerImpl(p, view);
		
		// Nome válido
		when(view.getNameFromTextField()).thenReturn("Barreto");
		controller.changedButtonPressed();
		assertEquals(p.getName(), "Barreto");
		
		// Nome inválido: sem começar com letra maiúscula
		when(view.getNameFromTextField()).thenReturn("barreto");
		controller.changedButtonPressed();
		assertNotEquals(p.getName(), "barreto");
		
	// Nome inválido: possui números
		when(view.getNameFromTextField()).thenReturn("Barreto123");
		controller.changedButtonPressed();
		assertNotEquals(p.getName(), "Barreto123");		
	}
	
	

}
