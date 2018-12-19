package hangman;

import java.util.Random;

public class Game {
	private Classmate classmate;
	private char[] guessed=new char[3];
	private int guessedCounter=0;
	private String surnameChosen="";
	public Game() {
		// Save into an array all the surnames of the people in class
		String[] surnames = {"lazkano","intxausti","artola","alberdi","lekubide","ortiz","gonzalez"};
		// Take randomly a surname between them
		String randomSurname = surnames[new Random().nextInt(surnames.length)];
		Classmate classmate = new Classmate(randomSurname);
		this.classmate=classmate;
	}
	public Classmate getClassmate() {
		return classmate;
	}
	public void setClassmate(Classmate classmate) {
		this.classmate=classmate;
	}
	public char[] getGuessed() {
		return guessed;
	}
	public void setGuessed(char[] guessed) {
		this.guessed=guessed;
	}
	public int getGuessedCounter() {
		return guessedCounter;
	}
	public void setGuessedCounter(int guessedCounter) {
		this.guessedCounter=guessedCounter;
	}
	public void printVoids() {
		// Print the word with voids
		for (int i = 0; i < classmate.getSurname().length(); i++) {
			System.out.print("_ ");
		}
	}
	public void printGuessed() {
		// Print the surname with only the letters that the player guessed
		for (int surnameIndex = 0; surnameIndex < classmate.getSurname().length(); surnameIndex++) {
			boolean found = false;
			for (int guessedIndex = 0; guessedIndex < guessed.length; guessedIndex++) {
				if (guessed[guessedIndex] == classmate.getSurname().charAt(surnameIndex)) {
					System.out.print(classmate.getSurname().charAt(surnameIndex) + " ");
					found = true;
				}
			}
			if (!found) {
				System.out.print("_ ");
			}
		}
	}
	public boolean checkWord(String playerWord) {
		String[] playerWordArray = playerWord.split(" ");
		if (playerWordArray.length == 1) {
			boolean numberFound = false;
			for (int i = 0; i < playerWordArray[0].length(); i++) {
				if (playerWordArray[0].charAt(i) == '0' || playerWordArray[0].charAt(i) == '1'
						|| playerWordArray[0].charAt(i) == '2' || playerWordArray[0].charAt(i) == '3'
						|| playerWordArray[0].charAt(i) == '4' || playerWordArray[0].charAt(i) == '5'
						|| playerWordArray[0].charAt(i) == '6' || playerWordArray[0].charAt(i) == '7'
						|| playerWordArray[0].charAt(i) == '8' || playerWordArray[0].charAt(i) == '9') {
					numberFound = true;
					break;
				}
			}
			if (numberFound == false) {
				String surnameEntered=playerWordArray[0];
				if (surnameEntered.equals(getClassmate().getSurname())) {
					System.out.println("Congrats, you won the game.");
				} else {
					System.out.println("I'm sorry, you lost the game. The surname was " + getClassmate().getSurname());
				}
			} else {
				System.out.println("Please, enter a real surname.");
			}
		} else {
			System.out.println("Please, enter just a surname.");
		}
	}
}