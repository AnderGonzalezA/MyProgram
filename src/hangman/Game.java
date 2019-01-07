package hangman;

import java.util.Random;

public class Game {
	private char[] guessed=new char[3];
	private int guessedCounter=0;
	private String randomSurname="";
	public Game() {
		// Save into an array all the surnames of the people in class
		String[] surnames = {"lazkano","intxausti","artola","alberdi","lekubide","ortiz","gonzalez"};
		// Take randomly a surname between them
		this.randomSurname = surnames[new Random().nextInt(surnames.length)];
	}
	public char[] getGuessed() {
		return this.guessed;
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
	public String getRandomSurname() {
		return this.randomSurname;
	}
	public void setRandomSurname(String randomSurname) {
		this.randomSurname=randomSurname;
	}
	public void printVoids() {
		// Print the word with voids
		for (int i = 0; i < this.randomSurname.length(); i++) {
			System.out.print("_ ");
		}
	}
	public void printGuessed() {
		// Print the surname with only the letters that the player guessed
		for (int surnameIndex = 0; surnameIndex < this.randomSurname.length(); surnameIndex++) {
			boolean found = false;
			for (int guessedIndex = 0; guessedIndex < guessed.length; guessedIndex++) {
				if (guessed[guessedIndex] == this.randomSurname.charAt(surnameIndex)) {
					System.out.print(this.randomSurname.charAt(surnameIndex) + " ");
					found = true;
				}
			}
			if (!found) {
				System.out.print("_ ");
			}
		}
	}
	public void checkLetter(char playerLetter) {
		for (int surnameIndex = 0; surnameIndex < this.randomSurname.length(); surnameIndex++) {
			if (this.randomSurname.charAt(surnameIndex) == playerLetter) {
				// If it is, open another loop which will go checking if the player had already
				// guessed that letter
				boolean found = false;
				int guessedIndex = 0;
				while (guessedIndex < this.guessed.length && this.guessed[guessedIndex] != playerLetter
						&& !found) {
					// Check that the cell of the array is empty
					if (!Character.isLetter(this.guessed[guessedIndex])) {
						// If he/she had not done so, save the letter in the array 'guessed'
						this.guessed[this.guessedCounter] = this.randomSurname.charAt(surnameIndex);
						// Increment once the variable 'guessedCounter' for a future possible letter
						this.guessedCounter++;
						// Define the variable 'found' as true so as to get out of the loop
						found = true;
					}
					// Increment the variable 'guessedIndex' so as to check the next letter of the array
					// 'guessed'
					guessedIndex++;
				}
				break;
			}
		}
	}
	public boolean checkWord(String playerWord) {
		if (playerWord.equals(this.randomSurname)) {
			return true;
		} else {
			return false;
		}
	}
}