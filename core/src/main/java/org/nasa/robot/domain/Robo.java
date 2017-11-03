package org.nasa.robot.domain;

public class Robo {

	private int longitude;
	private int latitude;
	private Direcao direcao;

	public Robo() {
		this.direcao = Direcao.NORTE;
		this.longitude = 0;
		this.latitude = 0;
	}

	public void mover(char comando) {
		if (comando == 'M')
			this.andar();
		else if (comando == 'L')
			this.rotacionarEsquerda();
		else if (comando == 'R')
			this.rotacionarDireita();
		else
			throw new IndexOutOfBoundsException("Somente comando s 'M', 'L' ou 'R' são aceitos");
	}

	private void rotacionarEsquerda() {
		if (this.direcao == Direcao.NORTE)
			this.direcao = Direcao.OESTE;
		else if (this.direcao == Direcao.SUL)
			this.direcao = Direcao.LESTE;
		else if (this.direcao == Direcao.LESTE)
			this.direcao = Direcao.NORTE;
		else if (this.direcao == Direcao.OESTE)
			this.direcao = Direcao.SUL;
	}

	private void rotacionarDireita() {
		if (this.direcao == Direcao.NORTE)
			this.direcao = Direcao.LESTE;
		else if (this.direcao == Direcao.SUL)
			this.direcao = Direcao.OESTE;
		else if (this.direcao == Direcao.LESTE)
			this.direcao = Direcao.SUL;
		else if (this.direcao == Direcao.OESTE)
			this.direcao = Direcao.NORTE;
	}

	private void andar() {
		if (this.direcao == Direcao.NORTE) {
			if (latitude < 4)
				latitude++;
			else
				throw new IndexOutOfBoundsException("O Robo não pode avançar para o Norte");
		} else if (this.direcao == Direcao.SUL) {
			if (latitude > 0)
				latitude--;
			else
				throw new IndexOutOfBoundsException("O Robo não pode avançar para o Sul");
		} else if (this.direcao == Direcao.LESTE) {
			if (longitude < 4)
				longitude++;
			else
				throw new IndexOutOfBoundsException("O Robo não pode avançar para o Leste");
		} else if (this.direcao == Direcao.OESTE) {
			if (longitude > 0)
				longitude--;
			else
				throw new IndexOutOfBoundsException("O Robo não pode avançar para o Oeste");
		}
	}

	public String retornarPosicaoAtual() {
		return "(" + longitude + ", " + latitude + ", " + direcao.getDirecaoId() + ")";
	}
}
