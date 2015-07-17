// A First Grader
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] number = new int[n];
		for (int i = 0; i < n; i++)
			number[i] = sc.nextInt();
		long[][] dp = new long[n - 1][21];
		dp[0][number[0]] = 1;
		for (int i = 1; i < n - 1; i++) {
			for (int j = 0; j < 21; j++) {
				if (dp[i - 1][j] > 0) {
					if (j + number[i] < 21)
						dp[i][j + number[i]] += dp[i - 1][j];
					if (j - number[i] >= 0)
						dp[i][j - number[i]] += dp[i - 1][j];
				}
			}
		}
		System.out.println(dp[n - 2][number[n - 1]]);
		sc.close();
	}
}
