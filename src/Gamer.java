/**
 * 
 */

/**
 * The gamer class defines the attributes of the dealer and the player of the
 * game
 * The date is 6/28/2020
 * 
 * @author Anirvin Vaddiyar
 *
 */
public class Gamer {

	private Card[] hand = new Card[1000];
	private boolean aceValueSet;

	public Gamer() {

	}

	/**
	 * @return
	 */
	public boolean isAceValueSet() {
		return aceValueSet;
	}

	/**
	 * @param aceValueSet
	 */
	public void setAceValueSet(boolean aceValueSet) {
		this.aceValueSet = aceValueSet;
	}

	/**
	 * @return
	 */
	public int getGamerPointTotal() {

		int sum = 0;

		for (int i = 0; i < hand.length; i++) {
			if (hand[i] != null)
				sum += hand[i].getPointValue();
		}

		return sum;
	}

	/**
	 * @return
	 */
	public Card[] getHand() {
		return hand;
	}

	public void endPlayer() {

		for (int i = 0; i < hand.length; i++) {

			hand[i] = null;

		}

	}

}
