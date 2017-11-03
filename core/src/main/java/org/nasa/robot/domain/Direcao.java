package org.nasa.robot.domain;

public enum Direcao {
	NORTE("N"), SUL("S"), LESTE("E"), OESTE("W");

	private final String direcao;

	private Direcao(final String direcao) {
		this.direcao = direcao;
	}

	public String getDirecaoId() {
		return this.direcao;
	}
}
