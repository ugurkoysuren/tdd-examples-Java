package net.davidtanzer.tdd.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TicTacToeControllerTest {

	@Test
	public void leeresGitterWirdAngezeigt() {
		TicTacToe ticTacToe = new TicTacToe();
		String gitter = ticTacToe.getController().zeigeGitterAn();
		assertThat(gitter).isEqualTo(" _  _  _  _  _  _  _  _  _ ");
	}
	
	@Test
	public void spielerXIstAnDerReihe() {
		TicTacToe ticTacToe = new TicTacToe();
		String anDerReihe = ticTacToe.getController().spielerXIstAnDerReihe();
		assertThat(anDerReihe).isEqualTo("Spieler X ist an der Reihe.");
	}
	
	@Test
	public void gewaehltesFeldIstFrei() {
		TicTacToe ticTacToe = new TicTacToe();
		
		//assertThat(anDerReihe).isEqualTo("Spieler X ist an der Reihe.");
	}

}