// Ennichi
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	int[] dp;
	String s;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		s = sc.next();
		dp = new int[n];
		Arrays.fill(dp, -1);
		System.out.println(dfs(n));
		sc.close();
	}

	int dfs(int n) {
		if (n <= 0)
			return Integer.MAX_VALUE / 10;
		if (dp[n - 1] != -1)
			return dp[n - 1];
		if (n == 1)
			dp[n - 1] = 0;
		else if (s.charAt(n - 1) == 'X')
			dp[n - 1] = Math.min(Math.min(dfs(n - 1) + 1, dfs(n - 2) + 1),
					dfs(n - 3) + 1);
		else
			dp[n - 1] = Math.min(Math.min(dfs(n - 1), dfs(n - 2)), dfs(n - 3));
		return dp[n - 1];
	}
}
