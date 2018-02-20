package net.davidtanzer.tdd.tictactoe;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import net.davidtanzer.tdd.tictactoe.test.Gamestate;
import net.davidtanzer.tdd.tictactoe.test.GamestateRenderer;

public class TicTacToeController {

	private Gamestate gamestate;
	private GamestateRenderer renderer;
	private InputStream input;
	private PrintWriter output;

	public TicTacToeController(InputStream input, PrintWriter output, Gamestate gamestate, GamestateRenderer renderer) {
		this.input = input;
		this.gamestate = gamestate;
		this.renderer = renderer;
		this.output = output;
	}

	public void nextMove() throws IOException {
		int inputNumber = input.read();
		if (inputNumber >= '1' && inputNumber <= '9') {
			gamestate.updatePosition((byte) inputNumber);
			String str = renderer.render(gamestate);
			output.print(str);
			output.println();
		}
	}

}
