package net.davidtanzer.tdd.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class GamestateRendererTest {

	@Test
	public void erzeugtKorrektenStringAusGamestate() {
		Player[] currentState = new Player[] { Player.O, Player.X, Player.X, Player.NONE, Player.NONE, Player.NONE,
				Player.NONE, Player.NONE, Player.O };
		Gamestate state = new Gamestate(currentState);
		GamestateRenderer renderer = new GamestateRenderer();

		String output = renderer.render(state);

		assertThat(output).startsWith(" O  X  X \n _  _  _ \n _  _  O ");
	}

	@Test
	
	public void whosTurn() {
		Player[] currentState = new Player[] { Player.O, Player.X, Player.X, Player.NONE, Player.NONE, Player.NONE,
				Player.NONE, Player.X, Player.O };
		Gamestate state = new Gamestate(currentState);
		GamestateRenderer renderer = new GamestateRenderer();
		String output = renderer.render(state);
		
		assertThat(output).endsWith("Spieler O am Zug: ");

	}
}