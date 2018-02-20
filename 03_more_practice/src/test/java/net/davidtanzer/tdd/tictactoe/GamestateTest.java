package net.davidtanzer.tdd.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class GamestateTest {

	@Test
	public void gamestateIsEmptyAtBeginning() {
		Gamestate state = new Gamestate();
		assertThat(state.getField()).containsExactly(Player.NONE, Player.NONE, Player.NONE, Player.NONE, Player.NONE,
				Player.NONE, Player.NONE, Player.NONE, Player.NONE);
	}

	@Test
	public void getGamestateAfterThreeMoves() {
		Gamestate state = new Gamestate();
		state.updateState('1');
		state.updateState('3');
		state.updateState('5');
		assertThat(state.getField()).containsExactly(Player.X, Player.NONE, Player.O, Player.NONE, Player.X,
				Player.NONE, Player.NONE, Player.NONE, Player.NONE);
	}

	@Test
	public void nextPlayerisXwhenXandOturnsAreEqual() {
		Player[] currentState = new Player[] { Player.O, Player.X, Player.X, Player.NONE, Player.NONE, Player.NONE,
				Player.NONE, Player.NONE, Player.O };
		Gamestate state = new Gamestate(currentState);
		assertThat(state.getNextPlayer()).isEqualTo(Player.X);
	}
	@Test
	public void nextPlayerisOwhenXandOturnsAreNotEqual() {
		Player[] currentState = new Player[] { Player.O, Player.X, Player.X, Player.X, Player.NONE, Player.NONE,
				Player.NONE, Player.NONE, Player.O };
		Gamestate state = new Gamestate(currentState);
		assertThat(state.getNextPlayer()).isEqualTo(Player.O);
	}
}