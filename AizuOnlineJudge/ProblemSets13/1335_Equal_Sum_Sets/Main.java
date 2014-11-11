// Equal Sum Sets
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][][] dp = new int[21][11][156];
		dp[0][0][0] = 1;
		for (int n = 1; n < 21; n++)
			for (int k = 0; k < 11; k++)
				for (int s = 0; s < 156; s++) {
					dp[n][k][s] += dp[n - 1][k][s];
					if (k > 0 && s >= n)
						dp[n][k][s] += dp[n - 1][k - 1][s - n];
				}
		while (true) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int s = sc.nextInt();
			if ((n | k | s) == 0)
				break;
			System.out.println(dp[n][k][s]);
		}
		sc.close();
	}
}
