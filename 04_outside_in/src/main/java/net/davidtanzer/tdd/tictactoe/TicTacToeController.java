package net.davidtanzer.tdd.tictactoe;

import java.util.ArrayList;

public class TicTacToeController {

	TicTacToe tictactoe;

	TicTacToeController(TicTacToe tictactoe) {
		this.tictactoe = tictactoe;
	}

	public String spielerXIstAnDerReihe() {

		return "Spieler X ist an der Reihe.";
	}

	public String zeigeGitterAn() {
		String spielFeld = "";
		ArrayList<Boolean> spielfeld = tictactoe.getSpielfeld();
		for (int i = 0; i < 9; i++) {
			if (spielfeld.get(i)) {
				spielFeld += " X ";
			} else if (spielfeld.get(i) == false) {
				spielFeld += " O ";
			} else {
				spielFeld += " _ ";
			}
		}

		return spielFeld;
	}

}