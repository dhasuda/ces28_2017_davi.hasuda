package Q4Tests;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import Q4.ControladorPTC;
import Q4.Datacenter;
import Q4.PainelCondutor;
import Q4.Sensor;

public class testesQ4 {
	
	private Sensor sensor;
	private Datacenter dataCenter;
	private PainelCondutor painel;
	
	@Before
	public void setUp() {
		sensor = mock(Sensor.class);
		dataCenter = mock(Datacenter.class);
		painel = mock(PainelCondutor.class);
	}

	/*
	 * Alternativa A
	 * Testa a inicialização de um objeto ControladorPTC
	 * */
	@Test
	public void testA() {
		ControladorPTC controlador = new ControladorPTC(sensor, dataCenter, painel);
		assertNotNull(controlador);
	}
	
	/*
	 * Alternativa B
	 * Testa um caso em que o trem não se encontra em um cruzamento
	 * */
	@Test
	public void testB() {
		when(sensor.isCruzamento()).thenReturn(false); // Não se encontra em um cruzamento
		when(sensor.getVelocidade()).thenReturn(19.0); // Valor aleatório apenas para testar
		String s = (new Double(19.0)).toString(); // Valor utilizado no método de painel para imprimir avisos
		when(painel.imprimeAviso(s, 1)).thenReturn(true); // Stub do método chamado dentro da classe ControladorPTC
		
		ControladorPTC controlador = spy(new ControladorPTC(sensor, dataCenter, painel)); // Spy da classe para saber se seu método é chamado
		
		controlador.run(); // Roda o código para checar se os métodos foram chamados corretamente
		verify(controlador, times(1)).enviaMsgDatacenter(sensor.getVelocidade(), dataCenter); // Verificar se foi chamada exatamente 1 vez
		verify(controlador, times(1)).enviaMsgNormalPainel(sensor.getVelocidade(), painel); // Verificar se foi chamada exatamente 1 vez
	}
	
	/*
	 * Alternativa C
	 * Testa um caso em que o trem se encontra em um cruzamento e sua velocidade é maior do que 100km/h
	 * */
	@Test
	public void testC() {
		when(sensor.isCruzamento()).thenReturn(true); // Se encontra em um cruzamento
		when(sensor.getVelocidade()).thenReturn(150.0); // Velocidade do trem acima de 100km/h
		when(painel.imprimeAviso("Velocidade alta", 1)).thenReturn(true); // Para que o valor de enviaMsgPrioritariaPainel() seja true
		
		ControladorPTC controlador = spy(new ControladorPTC(sensor, dataCenter, painel)); // Spy da classe para saber se seu método é chamado
		
		controlador.run(); // Roda o código para checar se os métodos foram chamados corretamente
		verify(controlador, times(1)).enviaMsgPrioritariaPainel("Velocidade alta", painel); // Verificar se foi chamada exatamente 1 vez
		verify(controlador, never()).diminuiVelocidade(20);
	}
	
	/*
	 * Alternativa D
	 * Testa um caso em que o trem se encontra em um cruzamento e sua velocidade é menor do que 20km/h
	 * */
	@Test
	public void testD() {
		when(sensor.isCruzamento()).thenReturn(true); // Se encontra em um cruzamento
		when(sensor.getVelocidade()).thenReturn(19.0); // Valor abaixo de 20km/h
		when(painel.imprimeAviso("Velocidade Baixa", 1)).thenReturn(false); // Para que o valor de enviaMsgPrioritariaPainel() seja true
		
		ControladorPTC controlador = spy(new ControladorPTC(sensor, dataCenter, painel)); // Spy da classe para saber se seu método é chamado
		
		controlador.run(); // Roda o código para checar se os métodos foram chamados corretamente
		
		verify(controlador, times(1)).aumentaVelocidade(20); // Verificar se foi chamada exatamente 1 vez
	}
	

}
