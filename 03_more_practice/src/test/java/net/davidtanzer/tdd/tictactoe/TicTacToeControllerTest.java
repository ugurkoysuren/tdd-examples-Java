package net.davidtanzer.tdd.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

class TicTacToeControllerTest {

	@Test
	void zeigtSpielfeldKorrektAn() throws IOException {
		ByteArrayOutputStream streamer = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(streamer);
		InputStream input = new ByteArrayInputStream(new byte[] {});
		Gamestate state = new Gamestate();
		GamestateRenderer renderer = new GamestateRenderer();

		
		TicTacToeController controller = new TicTacToeController(stream, input, state, renderer);

		controller.nextMove();
		String output = new String(streamer.toByteArray());
		assertThat(output).startsWith(" _  _  _ \n _  _  _ \n _  _  _ \nSpieler X am Zug: ");
	}
	
	@Test
	void zeigtSpielfeldKorrektAnNachEingabe() throws IOException {
		ByteArrayOutputStream streamer = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(streamer);
		ByteArrayInputStream input = new ByteArrayInputStream(new byte[] {'1'});
		Gamestate state = new Gamestate();
		GamestateRenderer renderer = new GamestateRenderer();
		
		TicTacToeController controller = new TicTacToeController(stream, input, state, renderer);
		
		controller.nextMove();
		streamer.reset();
		controller.nextMove();
		String output = new String(streamer.toByteArray());
		assertThat(output).startsWith(" X  _  _ \n _  _  _ \n _  _  _ \nSpieler O am Zug: ");
	}
	
	@Test
	void eingabeInvalid() throws IOException {
		ByteArrayOutputStream streamer = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(streamer);
		ByteArrayInputStream input = new ByteArrayInputStream(new byte[] {'a'});
		Gamestate state = new Gamestate();
		GamestateRenderer renderer = new GamestateRenderer();
		
		TicTacToeController controller = new TicTacToeController(stream, input, state, renderer);
		
		controller.nextMove();
		streamer.reset();
		controller.nextMove();
		String output = new String(streamer.toByteArray());
		assertThat(output).startsWith(" _  _  _ \n _  _  _ \n _  _  _ \nSpieler X am Zug: ");
	}
}