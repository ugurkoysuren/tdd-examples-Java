package net.davidtanzer.tdd.hangman;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Random;

class HangmanTest {
	private Hangman hangman = new Hangman();
	static ArrayList<String> codeNameList;
	private static String codeName;
	private static Character ch;

	@BeforeAll
	public static void setupCodeNameList() {
		codeNameList = new ArrayList<>();
		codeNameList.add("Angel");
		codeName = "deve";
		ch = ('e');
	}

	@Test
	public void chooseRandomCodeName() {
		Random random = new Random();
		String codeName = codeNameList.get(random.nextInt(1 - 0));
		assertThat(codeName).isNotNull();
	}

	@Test
	public void doesItInclude() {
		Character ch = new Character('e');
		assertThat(codeName.indexOf(ch)).isGreaterThanOrEqualTo(0);
	}

	@Test
	public void findIndex() {
		int i = codeName.indexOf(ch);
		while (i >= 0) {
			i = codeName.indexOf(ch, i + 1);
			switch (i) {
			case 1:
				assertThat(i).isEqualTo(1);
				break;

			case 3:
				assertThat(i).isEqualTo(3);
				break;
			default: 
				fail("Found false index: "+i);

			}
		}
	}
}