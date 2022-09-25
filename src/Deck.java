/**
 * 
 */

/**
 * This class defines the properties of a deck of cards in the game
 * The date is 6/28/2020
 * 
 * @author Anirvin Vaddiyar
 *
 */
public class Deck {

	private Card[] cards = new Card[52];

	public Deck() {

		for (int i = 0; i < cards.length; i++) {

			cards[i] = new Card(i);

		}
	}

	public Card[] getCards() {

		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

	/**
	 * @param i
	 * @return
	 */
	public Card getCard(int i) {

		return cards[i % 52];

	}

	/**
	 * 
	 */
	public void displayDeck() {

		for (int i = 0; i < cards.length; i++) {

			System.out.print(cards[i].displayCard() + "-" + cards[i].getSuit() + "  ");

			if ((i + 1) % 13 == 0 && i != 0)

				System.out.println();
		}

	}

	public void end() {

		for (int i = 0; i < cards.length; i++) {
			this.cards[i] = null;
		}
	}

}
