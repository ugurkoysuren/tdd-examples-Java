package net.davidtanzer.tdd.tictactoe;

public enum Player {
	X(" X ") {
		@Override
		public Player next() {
			return Player.O;
		}
	},
	O(" O ") {
		@Override
		public Player next() {
			return Player.X;
		}
		
		
	},
	NONE(" _ ");
	
	private String text;

	private Player(String text) {
		this.text = text;
	}
	

	public Player next() {
		throw new IllegalStateException();
	}

	public String getText() {
		return text;
	}
}
