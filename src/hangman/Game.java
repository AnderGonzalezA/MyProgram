package hangman;

import java.util.Random;

public class Game {
	private Classmate classmate;
	private char[] guessed=new char[3];
	private int guessedCounter=0;
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
}