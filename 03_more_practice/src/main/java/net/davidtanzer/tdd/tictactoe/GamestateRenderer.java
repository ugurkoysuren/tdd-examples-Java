package net.davidtanzer.tdd.tictactoe;

public class GamestateRenderer {

	public String render(Gamestate state) {
		StringBuilder builder = new StringBuilder();
		builder.append("");

		Player[] gamestate = state.getGamestate();
		for (int i = 0; i < gamestate.length; i++) {
			builder.append(gamestate[i].getText());
			if (i == 2 || i == 5) {
				builder.append("\n");
			}
		}

		if (state.getNextPlayer() == Player.O) {
			return builder.toString() + "\nSpieler O am Zug: ";
		}

		return builder.toString() + "\nSpieler X am Zug: ";
	}
}