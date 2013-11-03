import java.util.*;

public class Fastest_Route {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int[][] t = new int[n][n + 1];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n + 1; j++)
					t[i][j] = sc.nextInt();
			int[] dp = new int[1 << n];
			for (int i = 0; i < dp.length; i++)
				dp[i] = Integer.MAX_VALUE;
			dp[0] = 0;
			for (int i = 0; i < dp.length; i++)
				for (int j = 0; j < n; j++) {
					if ((i & (1 << j)) == 0) {
						dp[i + (1 << j)] = Math.min(dp[i + (1 << j)], dp[i]
								+ t[j][0]);
						for (int k = 0; k < n; k++)
							if ((i & (1 << k)) != 0)
								dp[i + (1 << j)] = Math.min(dp[i + (1 << j)],
										dp[i] + t[j][k + 1]);
					}
				}
			System.out.println(dp[dp.length - 1]);
		}
		sc.close();
	}
}
