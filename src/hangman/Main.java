package hangman;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// Print the games' description
		System.out.println("Welcome to the famous HANGMAN game.");
		System.out.println("You will have to guess which surname of the people in class is hidden between the voids.");
		System.out.println(
				"For this, you will be able to enter 3 letters that may appear in the surname, or not. After this, you will only have a chance to guess the surname and win the game.");
		boolean playAgain = true;
		while (playAgain == true) {
			Game game = new Game();
			game.printVoids();
			// Open a loop that will go asking to the player a possible letter in each turn
			int tries = 0;
			while (tries < 3) {
				// Check that the player doesn't enter a number
				if (!sc.hasNextInt()) {
					// Create a string object with the letter's value
					String entered = sc.nextLine().toLowerCase();
					String[] letterArray = entered.split(" ");
					if (letterArray.length == 1) {
						// Check that the player has entered just a character
						if (letterArray[0].length() == 1) {
							boolean numberFound = false;
							if (letterArray[0].charAt(0) == '0' || letterArray[0].charAt(0) == '1'
									|| letterArray[0].charAt(0) == '2' || letterArray[0].charAt(0) == '3'
									|| letterArray[0].charAt(0) == '4' || letterArray[0].charAt(0) == '5'
									|| letterArray[0].charAt(0) == '6' || letterArray[0].charAt(0) == '7'
									|| letterArray[0].charAt(0) == '8' || letterArray[0].charAt(0) == '9') {
								numberFound=true;
							}
							if (numberFound == false) {
								char letterEntered = letterArray[0].charAt(0);
								// Open a loop that will go checking if the letter the player entered is in the
								// surname
								for (int surnameIndex = 0; surnameIndex < game.getClassmate().getSurname().length(); surnameIndex++) {
									if (game.getClassmate().getSurname().charAt(surnameIndex) == letterEntered) {
										// If it is, open another loop which will go checking if the player had already
										// guessed that letter
										boolean found = false;
										int guessedIndex = 0;
										while (guessedIndex < game.getGuessed().length && game.getGuessed()[guessedIndex] != letterEntered
												&& !found) {
											// Check that the cell of the array is empty
											if (!Character.isLetter(game.getGuessed()[guessedIndex])) {
												// If he/she had not done so, save the letter in the array 'guessed'
												game.getGuessed()[game.getGuessedCounter()] = game.getClassmate().getSurname().charAt(surnameIndex);
												// Increment once the variable 'guessedCounter' for a future possible letter
												game.setGuessedCounter(game.getGuessedCounter()+1);
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
								// Increment 'tries' so as to ask for another letter
								tries++;
							} else {
								System.out.println("Please, enter a real letter.");
							}
						}
						// If the player entered more than one characters, ask him/her to enter just one
						else {
							System.out.println("Don't cheat, please enter just a letter.");
						}
					} else {
						System.out.println("Don't cheat, please enter just a letter.");
					}
				}
				// If the player entered a number, ask him to enter a letter
				else {
					System.out.println("That is not a letter, try it again.");
					sc.nextLine();
				}
				game.printGuessed();
				// Print to the letters that the player has left
				if (tries == 1) {
					System.out.println("You have two letters left.");
				} else if (tries == 2) {
					System.out.println("You have just a letter left.");
				}
			}
			// Ask to the player a possible word
			System.out.println("It's the time, you have to guess the word.");
			boolean wordEntered = false;
			while (wordEntered == false) {
				String playerWord = sc.nextLine().toLowerCase();
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
						wordEntered = true;
						String surnameEntered=playerWordArray[0];
						if (surnameEntered.equals(game.getClassmate().getSurname())) {
							System.out.println("Congrats, you won the game.");
						} else {
							System.out.println("I'm sorry, you lost the game. The surname was " + game.getClassmate().getSurname());
						}
					} else {
						System.out.println("Please, enter a real surname.");
					}
				} else {
					System.out.println("Please, enter just a surname.");
				}
			}
			// Ask if the player wants to play again
			System.out.println("Would you like to play again?(y/n)");
			boolean askAgain = true;
			while (askAgain == true) {
				String back = sc.next().toLowerCase();
				sc.nextLine();
				switch (back) {
				case "y":
					// Get out of the loop and play again
					askAgain = false;
					break;
				case "n":
					// Get out of the loop and terminate the program
					playAgain = false;
					askAgain = false;
					break;
				default:
					// Ask for a possible value again
					System.out.println("Please, select a possible value(y/n)");
					break;
				}
			}
		}
		sc.close();
	}

}
