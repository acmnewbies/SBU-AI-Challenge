
package SimpleDiceGame.GameAccessories;

public class Dice {

	private int diceStartingNumber;
	private int diceEndingNumber;

	public int throwDice() {
		int range = diceEndingNumber - diceStartingNumber + 1;
		int returnValue = (int) ( ( Math.random() * range ) + diceStartingNumber );
		return returnValue;
	}

	public Dice(int diceStartingNumber, int diceEndingNumber) {
		this.diceStartingNumber = diceStartingNumber;
		this.diceEndingNumber = diceEndingNumber;
	}

	public int getDiceStartingNumber() {
		return diceStartingNumber;
	}

	public void setDiceStartingNumber(int diceStartingNumber) {
		this.diceStartingNumber = diceStartingNumber;
	}

	public int getDiceEndingNumber() {
		return diceEndingNumber;
	}

	public void setDiceEndingNumber(int diceEndingNumber) {
		this.diceEndingNumber = diceEndingNumber;
	}
}
