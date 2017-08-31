package labmock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.mail.MessagingException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

public class LabMockTests {
	
	IServicoEmail email;
	IServicoDB db;
	IValidatorProcesso validador;
	SIAPJ siapj;
	
	@Before
	public void setUp() {
		email = mock(IServicoEmail.class);
		db = mock(IServicoDB.class);
		validador = mock(IValidatorProcesso.class);
		siapj = new SIAPJ(email, db, validador);
	}

	@Test
	public void testeInicializacaoSIAPJ() {
		assertNotNull(siapj);
	}
	
	@Test
	public void testeCriarReclamacao() throws SQLException {
		IProcesso processo1 = mock(IProcesso.class);
		IProcesso processo2 = mock(IProcesso.class);
		when(validador.validaProcesso(processo1)).thenReturn(true);
		
		when(processo1.getEmail()).thenReturn("teste@gmail.com");
		when(db.persisteProcesso(processo1)).thenReturn(1);
		when(email.sendEmail(processo1.getEmail(), "Processo aceito")).thenReturn(true);
	
		siapj.criaReclamacao(processo1);
		
		when(validador.validaProcesso(processo2)).thenReturn(false);
		when(email.sendEmail(processo2.getEmail(), "Existem erros em seu processo")).thenReturn(true);
		siapj.criaReclamacao(processo2);
		
		Mockito.verify(db, Mockito.times(1)).persisteProcesso(Mockito.any());
		Mockito.verify(email, Mockito.times(2)).sendEmail(Mockito.any(), Mockito.any());
		Mockito.verify(validador, Mockito.times(2)).validaProcesso(Mockito.any());
	}
	
	@Test
	public void testConexaoDB() throws SQLException, MessagingException {
		IProcesso processo1 = mock(IProcesso.class);
		IProcesso processo2 = mock(IProcesso.class);
		Statement mockStatement = mock(Statement.class);
		Connection mockConnection = mock(Connection.class);
		
		when(processo1.getEmail()).thenReturn("test1@gmail.com");
		when(processo2.getEmail()).thenReturn("test2@gmail.com");
		
		when(validador.validaProcesso(processo1)).thenReturn(true);
		when(validador.validaProcesso(processo2)).thenReturn(false);
		when(db.persisteProcesso(processo1)).thenReturn(1);
		
		when(email.sendEmail(processo1.getEmail(), "Processo aceito")).thenReturn(true);
		when(email.sendEmail(processo2.getEmail(), "Existem erros em seu processo")).thenReturn(true);
		
		when (mockConnection.createStatement()).thenReturn(mockStatement);
		when(mockConnection.createStatement().executeUpdate(Mockito.any())).thenReturn(1);
		
		siapj.criaReclamacao(processo1);
		siapj.criaReclamacao(processo2);
		
		Mockito.verify(mockConnection, Mockito.times(1)).createStatement();
	}
}
