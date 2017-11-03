package org.nasa.robot.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoboTest {

	@Test
	public void testValidacaoPosicaoInicial() {
		Robo robo = new Robo();
		assertEquals("(0, 0, N)", robo.retornarPosicaoAtual());
	}
	
	@Test
	public void deveAvancarUmaPosicaoParaONorte() {
		Robo robo = new Robo();
		for (char passo : "M".toCharArray()) {
			robo.mover(passo);
		}		
		assertEquals("(0, 1, N)", robo.retornarPosicaoAtual());
	}
	
	@Test
	public void deveAvancarUmaPosicaoParaOLeste() {
		Robo robo = new Robo();
		for (char passo : "RM".toCharArray()) {
			robo.mover(passo);
		}		
		assertEquals("(1, 0, E)", robo.retornarPosicaoAtual());
	}
	
	@Test
	public void deveAvancarUmaPosicaoParaOLesteEDepoisVoltarParaPosicaoAnterior() {
		Robo robo = new Robo();
		for (char passo : "RMRRM".toCharArray()) {
			robo.mover(passo);
		}		
		assertEquals("(0, 0, W)", robo.retornarPosicaoAtual());
	}
	
	@Test
	public void deveAvancarUmaPosicaoParaONorteEDepoisVoltarParaPosicaoAnterior() {
		Robo robo = new Robo();
		for (char passo : "MLLM".toCharArray()) {
			robo.mover(passo);
		}		
		assertEquals("(0, 0, S)", robo.retornarPosicaoAtual());
	}
	

	@Test(expected = IndexOutOfBoundsException.class)
	public void deveRetornarErroAoInformarUmComandoInvalido()  {
		Robo robo = new Robo();
		for (char passo : "AAA".toCharArray()) {
			robo.mover(passo);
		}		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void deveRetornarErroAoUltrapassarOLimiteDoTerrenoAoNorte()  {
		Robo robo = new Robo();
		for (char passo : "MMMMMM".toCharArray()) {
			robo.mover(passo);
		}			
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void deveRetornarErroAoUltrapassarOLimiteDoTerrenoAoSul()  {
		Robo robo = new Robo();
		for (char passo : "LLM".toCharArray()) {
			robo.mover(passo);
		}			
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void deveRetornarErroAoUltrapassarOLimiteDoTerrenoAoLeste()  {
		Robo robo = new Robo();
		for (char passo : "RMMMMM".toCharArray()) {
			robo.mover(passo);
		}			
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void deveRetornarErroAoUltrapassarOLimiteDoTerrenoAoOeste()  {
		Robo robo = new Robo();
		for (char passo : "LM".toCharArray()) {
			robo.mover(passo);
		}			
	}
	
	@Test
	public void deveGirar360GrausPelaDireira() {
		Robo robo = new Robo();
		for (char passo : "RRRR".toCharArray()) {
			robo.mover(passo);
		}		
		assertEquals("(0, 0, N)", robo.retornarPosicaoAtual());
	}
	
	@Test
	public void deveGirar360GrausPelaEsquerda() {
		Robo robo = new Robo();
		for (char passo : "LLLL".toCharArray()) {
			robo.mover(passo);
		}		
		assertEquals("(0, 0, N)", robo.retornarPosicaoAtual());
	}
}
