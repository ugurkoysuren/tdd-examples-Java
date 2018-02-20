package net.davidtanzer.tdd.tictactoe;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class TicTacToeController {

	private final PrintStream stream;
	private final InputStream input;
	private final Gamestate state;
	private final GamestateRenderer renderer;

	public TicTacToeController(PrintStream stream, InputStream input, Gamestate state, GamestateRenderer renderer) {
		this.stream = stream;
		this.input = input;
		this.state = state;
		this.renderer = renderer;
	}

	public boolean isRunning() {
		return true;
	}

	public void nextMove() throws IOException {
		String render = renderer.render(state);
		stream.println(render);

		int position = input.read();
		if (position >= '1' && position <= '9') {
			state.updateState(position);
		}
	}
}