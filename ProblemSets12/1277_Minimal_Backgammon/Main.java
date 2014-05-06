// Minimal Backgammon
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			int t = scanner.nextInt();
			int l = scanner.nextInt();
			int b = scanner.nextInt();
			if ((n | t | l | b) == 0)
				break;
			double[][] dp = new double[n + 1][t + 1];
			for (int i = 0; i < n + 1; i++)
				for (int j = 0; j < t + 1; j++)
					dp[i][j] = 0;
			boolean[] lose = new boolean[n + 1];
			boolean[] back = new boolean[n + 1];
			Arrays.fill(lose, false);
			Arrays.fill(back, false);
			for (int i = 0; i < l; i++)
				lose[scanner.nextInt()] = true;
			for (int i = 0; i < b; i++)
				back[scanner.nextInt()] = true;
			dp[0][0] = 1.0;
			for (int i = 0; i < t; i++) {
				for (int j = 0; j < n + 1; j++) {
					if (j == n) {
						dp[j][i + 1] += dp[j][i];
						continue;
					}
					for (int d = 1; d < 7; d++) {
						int next = j + d;
						if (next > n) {
							int a = next - n;
							next = n - a;
						}
						if (lose[next] && i < t - 1) {
							dp[next][i + 2] += dp[j][i] / 6.0;
						} else if (back[next]) {
							dp[0][i + 1] += dp[j][i] / 6.0;
						} else {
							dp[next][i + 1] += dp[j][i] / 6.0;
						}
					}
				}
			}
			System.out.printf("%.6f", dp[n][t]);
			System.out.println();
		}
		scanner.close();
	}
}
