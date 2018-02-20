package net.davidtanzer.tdd.tictactoe;

import java.util.Iterator;
import java.util.function.IntPredicate;

public class Gamestate {

	private int position;
	private Player[] gamestate = new Player[] { Player.NONE, Player.NONE, Player.NONE, Player.NONE, Player.NONE,
			Player.NONE, Player.NONE, Player.NONE, Player.NONE };
	private Player nextPlayer = Player.X;

	public Gamestate() {
		
	}

	public Gamestate(Player[] state) {
		int zahler=0;
		for (int i = 0; i < state.length; i++) {
			Player player = state[i];
			if(player == Player.X) {
				zahler++;
			}
			else if(player == Player.O) {
				zahler--;
			}
		}
		if(zahler > 0) {
			nextPlayer =  Player.O;
		}
		else{
			nextPlayer =  Player.X;
		}
		
		gamestate = state;
		
	}

	public void updateState(int position) {
		this.position = position;
		gamestate[position - '1'] = nextPlayer;
		nextPlayer = nextPlayer.next();
	}

	public int getPosition() {
		return position;
	}

	public Player[] getField() {
		return gamestate;
	}

	public Player[] getGamestate() {
		return gamestate;
	}

	public Player getNextPlayer() {
		return nextPlayer;
	}

}