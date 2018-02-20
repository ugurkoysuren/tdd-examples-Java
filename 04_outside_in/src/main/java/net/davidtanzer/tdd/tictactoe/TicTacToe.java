package net.davidtanzer.tdd.tictactoe;

import java.util.ArrayList;

public class TicTacToe {

	ArrayList<Boolean> spielfeld;
	private TicTacToeController controller;

	public TicTacToe() {
		spielfeld = new ArrayList<>(9);
		controller = new TicTacToeController(this);
	}

	public ArrayList<Boolean> getSpielfeld() {
		return spielfeld;
	}

	public void setSpielfeld(ArrayList<Boolean> spielfeld) {
		this.spielfeld = spielfeld;
	}
	
	public TicTacToeController getController() {
		return controller;
	}
}