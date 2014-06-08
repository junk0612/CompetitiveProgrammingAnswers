// A New Plan of Aizu Ski Resort
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int w = sc.nextInt(), h = sc.nextInt();
			if ((w | h) == 0)
				break;
			int[][] field = new int[h][w];
			int[][] dp = new int[h][w];
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++)
					field[i][j] = sc.nextInt();
			for (int i = 0; i < w; i++)
				if (field[0][i] == 0)
					dp[0][i] = 1;
			for (int i = 0; i < h - 1; i++) {
				for (int j = 0; j < w; j++) {
					switch (field[i][j]) {
					case 0:
						if (field[i + 1][j] != 1)
							dp[i + 1][j] += dp[i][j];
						if (j >= 1 && field[i + 1][j - 1] == 0)
							dp[i + 1][j - 1] += dp[i][j];
						if (j < w - 1 && field[i + 1][j + 1] == 0)
							dp[i + 1][j + 1] += dp[i][j];
						break;
					case 2:
						if (i < h - 2 && field[i + 2][j] != 1)
							dp[i + 2][j] += dp[i][j];
						break;
					}
				}
			}
			int result = 0;
			for (int i = 0; i < w; i++) {
				result += dp[h - 1][i];
				if (h >= 2 && field[h - 2][i] == 2)
					result += dp[h - 2][i];
			}
			System.out.println(result);
		}
		sc.close();
	}
}
