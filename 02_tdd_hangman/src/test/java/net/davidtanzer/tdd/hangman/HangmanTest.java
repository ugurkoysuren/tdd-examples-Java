package net.davidtanzer.tdd.hangman;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class HangmanTest {

	@Test
	public void zeigtPlatzhalterFuerWortMitEinemBuchstaben() {
		Hangman hangman = new Hangman("I");

		String platzhalter = hangman.zeigePlatzhalter();
		assertThat(platzhalter).isEqualTo("_");
	}

	@Test
	public void zeigtPlatzhalterFuerWortMitVierBuchstaben() {
		Hangman hangman = new Hangman("Ugur");

		String platzhalter = hangman.zeigePlatzhalter();
		assertThat(platzhalter).isEqualTo("____");
	}

	@Test
	public void nachEinemRichtigGeratenenBuchstabenWirdDerPlatzhalterKorrektAngezeigt() {
		Hangman hangman = new Hangman("Ugur");

		Character ch = new Character('u');
		hangman.rate(ch);
		String platzhalter = hangman.zeigePlatzhalter();

		assertThat(platzhalter).isEqualTo("u_u_");
	}

	@Test
	public void nachZweiRichtigGeratenenBuchstabenWirdDerPlatzhalterKorrektAngezeigt() {
		Hangman hangman = new Hangman("Ugur");

		Character ch1 = new Character('u');
		Character ch2 = new Character('g');
		hangman.rate(ch1);
		hangman.rate(ch2);
		String platzhalter = hangman.zeigePlatzhalter();

		assertThat(platzhalter).isEqualTo("ugu_");
	}

	@Test
	public void istHangmanStatusGewonnen() {
		Hangman hangman = new Hangman("i");
		Character ch = new Character('i');
		hangman.rate(ch);
		assertThat(hangman.spielGewonnen()).isTrue();
	}
	@Test
	public void spielIstNichtGewonnen() {
		Hangman hangman = new Hangman("i");
		assertThat(hangman.spielGewonnen()).isFalse();
	}
	
	@Test 
	public void istSpielVerloren() {
		Hangman hangman = new Hangman("i", 2);
		Character ch = new Character('a');
		hangman.rate(ch);
		hangman.rate(ch);
		assertThat(hangman.spielVerloren()).isTrue();
	}
	
	
	@Test 
	public void istSpielNochNichtVerloren() {
		Hangman hangman = new Hangman("i", 2);
		Character ch = new Character('a');
		hangman.rate(ch);
		assertThat(hangman.spielVerloren()).isFalse();
	}
	
	@Test 
	public void istSpielNichtVerloren() {
		Hangman hangman = new Hangman("i", 3);
		assertThat(hangman.spielVerloren()).isFalse();
	}
	
	@Test 
	public void gewonnenesSpielIstSpielNichtVerloren() {
		Hangman hangman = new Hangman("asdfg", 2);
		hangman.rate('a');
		hangman.rate('s');
		hangman.rate('d');
		hangman.rate('f');
		hangman.rate('g');
		assertThat(hangman.spielVerloren()).isFalse();
	}
	
	@Test 
	public void istSpielNichtVerlorenStandardAnzahl() {
		Hangman hangman = new Hangman("i");
		assertThat(hangman.spielVerloren()).isFalse();
	}
}