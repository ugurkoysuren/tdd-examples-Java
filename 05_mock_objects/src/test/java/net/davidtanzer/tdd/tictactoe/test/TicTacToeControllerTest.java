package net.davidtanzer.tdd.tictactoe.test;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import net.davidtanzer.tdd.tictactoe.TicTacToe;
import net.davidtanzer.tdd.tictactoe.TicTacToeController;

import static org.mockito.Mockito.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;

import static org.assertj.core.api.Assertions.*;

class TicTacToeControllerTest {
	private TicTacToe ticTacToe = new TicTacToe();

	@Test
	public void checkIfpositionIsCorrectTransmitted() throws IOException {
		Gamestate gamestate = Mockito.mock(Gamestate.class);
		GamestateRenderer renderer = Mockito.mock(GamestateRenderer.class);
		InputStream input = new ByteArrayInputStream(new byte[] { '1' });
		TicTacToeController controller = new TicTacToeController(input, null, gamestate, renderer);

		controller.nextMove();
		verify(gamestate).updatePosition((byte) '1');
	}

	@Test
	public void illegalCharacter() throws IOException {

		Gamestate gamestate = Mockito.mock(Gamestate.class);
		GamestateRenderer renderer = Mockito.mock(GamestateRenderer.class);
		InputStream input = new ByteArrayInputStream(new byte[] { 'A' });

		TicTacToeController controller = new TicTacToeController(input, null, gamestate, renderer);
		controller.nextMove();
		verify(gamestate, never()).updatePosition(anyByte());
	}

	@Test
	public void initGameField() throws IOException {

		Gamestate gamestate = Mockito.mock(Gamestate.class);
		GamestateRenderer renderer = Mockito.mock(GamestateRenderer.class);
		InputStream input = new ByteArrayInputStream(new byte[] { '1' });
		StringWriter sr = new StringWriter();
		PrintWriter output = new PrintWriter(sr);
		TicTacToeController controller = new TicTacToeController(input, output, gamestate, renderer);

		when(renderer.render(gamestate)).thenReturn(" O  X  X \n _  _  _ \n _  _  O ");
		controller.nextMove();
		assertThat(sr.toString()).startsWith(" O  X  X \n _  _  _ \n _  _  O ");
	}

	/* Gebrochen nach Refactoring */
	@Test
	public void initGameFieldWithMock() throws IOException {

		Gamestate gamestate = Mockito.mock(Gamestate.class);
		GamestateRenderer renderer = Mockito.mock(GamestateRenderer.class);
		// Do not mock what you don't own
		InputStream input = Mockito.mock(InputStream.class); // Nix gut
		PrintWriter output = Mockito.mock(PrintWriter.class); // Nix gut
		TicTacToeController controller = new TicTacToeController(input, output, gamestate, renderer);

		when(input.read()).thenReturn((int) '1');
		when(renderer.render(gamestate)).thenReturn(" O  X  X \n _  _  _ \n _  _  O ");
		controller.nextMove();
		verify(output).println(" O  X  X \n _  _  _ \n _  _  O ");
	}

	@Test
	public void checkIfpositionIsCorrectTransmittedWithArgumentCaptor() throws IOException {
		Gamestate gamestate = Mockito.mock(Gamestate.class);
		GamestateRenderer renderer = Mockito.mock(GamestateRenderer.class);
		InputStream input = new ByteArrayInputStream(new byte[] { '1', '2', '3' });
		StringWriter sr = new StringWriter();
		PrintWriter output = new PrintWriter(sr);
		TicTacToeController controller = new TicTacToeController(input, output, gamestate, renderer);
		controller.nextMove();
		controller.nextMove();
		// controller.nextMove();

		ArgumentCaptor<Byte> captor = ArgumentCaptor.forClass(Byte.class);
		verify(gamestate, times(2)).updatePosition(captor.capture());// until here is everything working
		controller.nextMove();
		verify(gamestate, times(3)).updatePosition(captor.capture()); // it adds the new expectec values, so instead of
																		// 3 you will have 5 values 2+3
		assertThat(captor.getAllValues()).containsExactlyInAnyOrder((byte) '1', (byte) '3', (byte) '2');

	}
}