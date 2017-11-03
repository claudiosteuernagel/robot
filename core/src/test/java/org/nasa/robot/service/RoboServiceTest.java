package org.nasa.robot.service;

import org.junit.Test;
import org.nasa.robot.domain.Robo;

import static org.mockito.Mockito.*;

public class RoboServiceTest {
	private Robo robo = mock(Robo.class);

    private RoboService roboService = new RoboService();

    @Test(expected=IndexOutOfBoundsException.class)
    public void deveRetornarExceptionQuandoEnviarUmComandoInvalido() {
        
        roboService.mover("MA", robo);
        verify(robo, never()).mover(anyChar());
    }

    @Test
    public void deveEnviarTodosOsComandoAoRobo() {
        doNothing().when(robo).mover(anyChar());;

        roboService.mover("MMMLMLMMRM", robo);

        verify(robo, times(7)).mover('M');
        verify(robo, times(2)).mover('L');
        verify(robo, times(1)).mover('R');  
    }
}