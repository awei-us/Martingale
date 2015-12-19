/**
 * Extends the probability game class to implement Martingale strategy
 * @author Alexander Wei <alexander@awei.us>
 *
 */
public class MartingaleGame extends BettingGame {

	private final int WAGER;
	private int rollNumber = 0, maxValue = 0;
	private final boolean SILENT;

	public MartingaleGame(int initialFunds, int initialWager, boolean silent) {
		this.addFunds(initialFunds);
		WAGER = initialWager;
		SILENT = silent;
	}

	public String toString() {
		return "" + maxValue + "\n";
	}

	public void runMartingale() {
		this.wager = WAGER;

		while (this.getFunds() > 0 && this.getFunds() < 5000) {
			rollNumber++;
			this.roll();
			if (this.getState() < 48) {
				this.win();
				this.wager = WAGER;
			} else {
				this.wager *= 2;
				if (this.wager > this.getFunds())
					this.wager = this.getFunds();
			}
			if (this.getFunds() > maxValue)
				maxValue = this.getFunds();
			if (SILENT == false)
				System.out.println("Roll " + rollNumber + ", Funds = "
						+ this.getFunds() + ", Wager = " + this.wager);
		}
	}
}
