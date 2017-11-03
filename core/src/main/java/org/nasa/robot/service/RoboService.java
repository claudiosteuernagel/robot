package org.nasa.robot.service;

import org.nasa.robot.domain.Robo;
import org.springframework.stereotype.Service;

@Service
public class RoboService  {

	private static final String regex = "^[MLR\\.\\,\\+\\-]*$";

	public String mover(String comando, Robo robo)  {
		
		if (!validarComando(comando))
			throw new IndexOutOfBoundsException("Comando Inválido. Somente são aceitos comandos 'M', 'L' ou 'R'");

		for (char passo : comando.toCharArray()) {
			robo.mover(passo);
		}

		return robo.retornarPosicaoAtual();
	}

	private Boolean validarComando(String comando) {
		return comando.matches(regex);
	}

}
