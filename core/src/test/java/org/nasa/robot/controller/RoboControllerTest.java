package org.nasa.robot.controller;

import org.junit.Test;
import org.nasa.robot.domain.Robo;
import org.nasa.robot.service.RoboService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyChar;
import static org.mockito.Mockito.*;

public class RoboControllerTest {

	private RoboService roboService = mock(RoboService.class);

	private RoboController roboController = new RoboController(roboService);

	@Test
	public void deveRepassarOComandoRecebidoParaOServico() {
		
		
		when(roboService.mover(anyString(), any())).thenReturn("");

		roboController.post("MLMRMMLMRM");

		verify(roboService, times(1)).mover(eq("MLMRMMLMRM"), any());

		
	}
	
	@Test
	public void deveRetornarOValorRetornadoPeloServico() {
		String resultadoEsperado = "(1, 0, L)";
		
		when(roboService.mover(anyString(), any())).thenReturn(resultadoEsperado);

		String resultado = roboController.post("");

		assertEquals(resultadoEsperado, resultado);
	}
}
