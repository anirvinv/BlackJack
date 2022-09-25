import java.util.Scanner;

/**
 * This program executes a simple blackjack game. The date is 6/28/2020
 * 
 * @author Anirvin Vaddiyar
 *
 */

public class App {

	public static void main(String[] args) {

		String play = new String();

		Scanner input = null;

		Game game = null;

		do {
			input = new Scanner(System.in);
			// Create new game object
			game = new Game(new Deck());

			// start the game
			game.start();

			// Ask the user if they want to play again
			System.out.println("Do you want to play again(Yes/No)?");
			play = input.nextLine();

			// Only loops if the user's answer is yes
		} while (play.equalsIgnoreCase("yes"));

		// If user says no or anything other than "yes", then game ends and sets all
		// values to null until program is
		// ran again

		System.out.println("Game over!");

		// set everything to null -- indicates finishing
		game.end();
	}

}
