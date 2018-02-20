package net.davidtanzer.tdd.hangman;

import java.util.ArrayList;
import java.util.Random;

public class Hangman {
	
	ArrayList<String> codeNameList = new ArrayList<>();
	
	public Hangman() {
		codeNameList = new ArrayList<>();
		codeNameList.add("Angel");
		codeNameList.add("isento");
		codeNameList.add("Ugur");
		codeNameList.add("Andi");
		codeNameList.add("Test");
		codeNameList.add("Development");
		
	}
	
	public String chooseRandomCodeName() {
		Random random = new Random();
		String codeName = codeNameList.get(random.nextInt(5-0));
		return codeName;
	}
	
	public boolean doesItInclude(Character ch) {
		int index = codeName.indexOf(ch);
		return index >= 0;
	}
	
	public int doesItInclude(Character ch) {
		int index = codeName.indexOf(ch);
		return index;
	}
}
