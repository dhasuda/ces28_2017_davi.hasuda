package mvc;

import view.PersonDetailView;
//import view.PersonDetailViewListener;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
//import org.mockito.Mockito;

import model.Person;
import presenter.PersonDetailPresenterImpl;

public class Item4 {

	@Test
	public void test() {
		Person p = new Person("Rhuan");
		// Fazer o teste com PersonDetailViewListener no lugar da view
		PersonDetailView view = mock(PersonDetailView.class);
		PersonDetailPresenterImpl controller = new PersonDetailPresenterImpl(p, view);
		
		// Nome válido
		when(view.getNameFromTextField()).thenReturn("Barreto");
		controller.changeName();
		assertEquals(p.getName(), "Barreto");
		
		// Nome inválido: sem começar com letra maiúscula
		when(view.getNameFromTextField()).thenReturn("barreto");
		controller.changeName();
		assertNotEquals(p.getName(), "barreto");
		
	// Nome inválido: possui números
		when(view.getNameFromTextField()).thenReturn("Barreto123");
		controller.changeName();
		assertNotEquals(p.getName(), "Barreto123");		
	}
	
	

}
