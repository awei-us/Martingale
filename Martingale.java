import java.io.*;

/**
 * Martingale Simulator Easily adaptable for statistical analysis. Writes key
 * statistics to a CSV file
 * 
 * @author Alexander Wei <alexander@awei.us>
 * 
 */
public class Martingale {
	private static MartingaleGame game;

	public static void main(String[] args) throws Exception, IOException {

		BufferedWriter writer = null;

		writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("martingaleMaxs.csv"), "utf-8"));
		for (int i = 0; i < 1000; i++) {
			game = new MartingaleGame(100, 1, true);
			game.runMartingale();
			writer.write(game.toString());
		}

		writer.close();
	}
}
