package net.davidtanzer.tdd.hangman;

public class Hangman {
	private String codeName;
	private String platzhalter;
	private String geraten;
	private int anzahlVersuche = 11;
	private int aktuelleVersuche = 0;
	
	public Hangman(String codeName) {
		super();
		this.codeName = codeName.toLowerCase();
		geraten = "_";
		aktualisierePlatzhalter();
	}

	public Hangman(String codeName, int anzahlVersuche) {
		this(codeName);
		this.anzahlVersuche = anzahlVersuche;
	}

	public String zeigePlatzhalter() {
		
		return platzhalter;
	} 

	public void rate(Character ch) {
		geraten += ch;
		if (korrektGeraten(ch)) {
			aktualisierePlatzhalter();
		} else {
			aktuelleVersuche++;
		}
	}

	private boolean korrektGeraten(Character ch) {
		return codeName.contains(ch.toString());
	}

	private void aktualisierePlatzhalter() {
		platzhalter = codeName.replaceAll("[^" + geraten + "]", "_");
	}

	public boolean spielGewonnen() {
		return codeName.equals(platzhalter);		
	}

	public boolean spielVerloren() {
		return aktuelleVersuche >= anzahlVersuche;
	}
}