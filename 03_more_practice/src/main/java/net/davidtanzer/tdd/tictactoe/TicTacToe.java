package net.davidtanzer.tdd.tictactoe;

import java.io.IOException;

public class TicTacToe {
	
	public static void main (String[] args) throws IOException {
		
		TicTacToeController controller = new TicTacToeController(System.out, System.in, new Gamestate(), new GamestateRenderer());
		
		while(controller.isRunning()) {
			controller.nextMove();
		}
	}
}