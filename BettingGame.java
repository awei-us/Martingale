/**
 * Probability game class, "rolls" a number 0-99
 * 
 * @author Alexander Wei <alexander@awei.us>
 * 
 */
public class BettingGame {
	private int state;
	private int account;
	public int wager;

	public int getState() {
		return state;
	}

	public void roll() {
		state = (int) (Math.random() * 100);
		account -= wager;
		return;
	}

	public void addFunds(int funds) {
		account += funds;
		return;
	}

	public void win() {
		account += wager * 2;
	}

	public int getFunds() {
		return account;
	}
}
