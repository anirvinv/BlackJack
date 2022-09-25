
/**
 * 
 */

import java.util.Scanner;

/**
 * This class defines how the game should be run.
 * The date is 6/28/2020
 * 
 * @author Anirvin Vaddiyar
 *
 */
public class Game {

	private static int count = 0;
	private Deck deck;

	// Player Object is created and contains all the data that the player would
	// receive such as cards, total score, etc.
	Gamer player = null;

	// Dealer Object is created and contains all the data that the dealer would
	// receive such as cards, total score, etc.
	Gamer dealer = null;

	public Game() {

	}

	public Game(Deck deck) {
		this.deck = deck;

	}

	public void start() {

		Scanner input = new Scanner(System.in);
		Scanner input2 = new Scanner(System.in);

		start: {

			count = 0;

			player = new Gamer();
			dealer = new Gamer();

			System.out.println();

			// shuffle the deck before starting the game
			shuffleDeck();

			// Give Player two hits and display the cards for him
			hit(player);
			hit(player);

			System.out.println("Player Cards: ");
			System.out.println();
			// Displays the player's hand of cards right after he/she receives two hits from
			// the dealer

			displayHand(player.getHand());
			System.out.println();
			// Enables the player to select the value of their "ace" card to be either 1 or
			// 11. If they enter a value other than 1 or 11, it will be defaulted to 1.
			// allows for user to reset their ace value depending on their hand.

			for (int i = 0; i < player.getHand().length; i++) {
				if (player.getHand()[i] != null && player.getHand()[i].getPointValue() == 1) {
					System.out.println();
					System.out.println("Would you like your ace to be worth 1 or 11 points?(Type 1 or 11)");

					int ace1 = input.nextInt();

					player.getHand()[i].setPointValue(ace1);

				}

			}
			// immediate victory for player if their total is 21
			if (player.getGamerPointTotal() == 21) {
				System.out.println("You win!!");
				break start;
			}
			// immediate loss for player if their total exceeds 21
			if (player.getGamerPointTotal() > 21) {
				System.out.println("Game Over... You lose!");
				break start;
			}

			System.out.println();
			// Displays the point total of the player
			System.out.println("Point total: " + player.getGamerPointTotal());

			System.out.println();
			// Asks player to hit or stay
			System.out.println("Hit or Stay (hit/stay)?");

			String userOption = input2.nextLine();

			// checks the user input for "hit" or "stay" string and if string is "hit" it
			// executes the following while loop.
			while (userOption.equalsIgnoreCase("Hit")) {

				hit(player);
				System.out.println();
				System.out.println("Player Cards: ");
				System.out.println();

				// displays new hand after being hit
				displayHand(player.getHand());
				System.out.println();

				for (int i = 0; i < player.getHand().length; i++) {
					if (player.getHand()[i] != null && player.getHand()[i].getPointValue() == 1) {

						// Again, the user has choice of the point value of their Ace card if they are
						// dealt one.
						// For every hit, they have the choice to change the value of their ace card to
						// their advantage.

						System.out.println("Would you like your ace to be worth 1 or 11 points?(Type 1 or 11): ");

						int ace2 = input.nextInt();

						player.getHand()[i].setPointValue(ace2);
					}
				}

				System.out.println();
				// displays point total of the player
				System.out.println("New Total: " + player.getGamerPointTotal());
				System.out.println();

				// if the point total exceeds 21, the player looses
				if (player.getGamerPointTotal() > 21) {

					System.out.println("Game Over... You Lose!!");
					break start;
				}
				// if the point total equals 21, the player wins
				else if (player.getGamerPointTotal() == 21) {
					System.out.println("You Win!!!");
					break start;
				}

				System.out.println("Hit or Stay (hit/stay)?");
				userOption = input2.nextLine();
			}

			hit(dealer);
			hit(dealer);

			System.out.println("Dealer Cards:");
			System.out.println();
			// The dealer's hand of cards is displayed
			displayHand(dealer.getHand());
			System.out.println();
			// When the player chooses to "Stay", the dealer looks at his cards
			while (userOption.equalsIgnoreCase("Stay")) {

				// Until the point total of the dealer's hand exceeds the value of 17, the
				// dealer will continue to draw cards from the deck
				while (dealer.getGamerPointTotal() <= 17) {
					hit(dealer);
				}

				System.out.println();

				System.out.println("Dealer Cards: ");
				System.out.println();
				// displays the dealer's cards after the hits
				displayHand(dealer.getHand());
				System.out.println();
				// displays the total point value of the dealer's hand
				System.out.println();
				System.out.println("Dealer Total: " + dealer.getGamerPointTotal());
				System.out.println();
				// if the dealer's point value is greater than 21, the player wins
				if (dealer.getGamerPointTotal() > 21) {
					System.out.println("You Win!!");
					break start;
				}
				// if the dealer's point value is equal to 21, the player loses
				if (dealer.getGamerPointTotal() == 21) {
					System.out.println("You lose!!");
					break start;
				}
				System.out.println();
				// Dealer's total points are displayed
				System.out.println("Dealer Point total: " + dealer.getGamerPointTotal());
				System.out.println();

				// if the point total of the dealer is less than 21, the point totals of the
				// dealer and player are compared by measuring the difference from 21.

				if (dealer.getGamerPointTotal() < 21
						&& (21 - dealer.getGamerPointTotal()) < (21 - player.getGamerPointTotal())) {
					System.out.println("You Lose!!");
					break start;
				}
				// If the dealer has a lower difference from 21, the dealer wins. If the player
				// has a lower difference, the player wins.

				else if (dealer.getGamerPointTotal() < 21
						&& (21 - dealer.getGamerPointTotal()) > (21 - player.getGamerPointTotal())) {
					System.out.println("You win!");
					break start;
				}
				// If the dealer and player get the same score, then it results in a tie

				else if (dealer.getGamerPointTotal() == player.getGamerPointTotal()) {
					System.out.println("Its a Tie!!");
					break start;
				}

			}
		}

	}

	/**
	 * 
	 */
	public void end() {

		this.deck.end();

		this.player.endPlayer();

		this.dealer.endPlayer();

	}

	/**
	 * 
	 */
	public void shuffleDeck() {

		Card[] cards = deck.getCards();

		for (int i = 0; i < cards.length; i++) {

			int j = (int) (Math.random() * cards.length);

			Card temp = cards[i];

			cards[i] = cards[j];

			cards[j] = temp;
		}
		deck.setCards(cards);

	}

	/**
	 * @param cards
	 */
	public void displayHand(Card[] cards) {

		for (int i = 0; i < cards.length; i++) {
			if (cards[i] != null) {
				System.out.print(cards[i].displayCard() + "-" + cards[i].getSuit() + " ");
			}
		}

	}

	/**
	 * @param gamer
	 */
	public void hit(Gamer gamer) {

		gamer.getHand()[count] = deck.getCard(count);
		count++;

	}

}
