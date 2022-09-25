/**
 * 
 */

/**
 * This class defines the properties of each of the cards in a deck in the game.
 * The date is 6/28/2020
 * 
 * @author Anirvin Vaddiyar
 *
 */

public class Card {
	private String[] suite = { "C", "D", "H", "S" };
	private int i = 1;
	private static int count = 0;
	private int faceValue;
	private int pointValue;

	public String toString() {
		String s = "Card Face Vaue-->" + faceValue + "--Point Value:" + pointValue;
		return s;
	}

	/**
	 * @param i Card constructor
	 */
	public Card(int i) {
		this.i = i;
		count++;
	}

	/**
	 * @return
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @return
	 */
	public int getFaceValue() {

		this.faceValue = i % 13 + 1;

		return faceValue;

	}

	/**
	 * @return
	 */
	public String displayCard() {

		this.faceValue = i % 13 + 1;

		if (faceValue == 1) {
			return "A";
		}

		if (faceValue <= 10) {
			String cardFace = (i % 13 + 1) + "";

			return cardFace;
		}

		if (faceValue == 11) {
			return "J";
		}
		if (faceValue == 12) {
			return "Q";
		}
		if (faceValue == 13) {
			return "K";
		} else
			return "";

	}

	/**
	 * @param ace
	 */
	public void setPointValue(int ace) {

		this.pointValue = ace;

	}

	/**
	 * @return
	 */
	public int getPointValue() {

		// if card is a jack, return 10
		if (pointValue == 11 & faceValue == 11) {

			return 10;
		}
		// if the card is not an ace, executes the following code
		if (pointValue != 11 && pointValue != 1) {

			this.pointValue = i % 13 + 1;

			if (pointValue > 10) {
				return 10;
			} else
				return pointValue;
		}
		// if the card is an ace, program returns user input value
		else
			return pointValue;

	}

	/**
	 * @return
	 */
	public String getSuit() {

		// returns a string based on the card position
		return suite[(i) / 13];

	}

}
