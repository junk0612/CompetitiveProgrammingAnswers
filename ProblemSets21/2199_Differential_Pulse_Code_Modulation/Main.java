import java.util.*;

public class Differential_Pulse_Code_Modulation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == 0 && m == 0)
				break;
			int[][] dp = new int[n][256];
			boolean[][] dpb = new boolean[n][256];
			int[] sample = new int[n];
			int[] code = new int[m];
			for (int i = 0; i < m; i++)
				code[i] = sc.nextInt();
			for (int i = 0; i < n; i++) {
				sample[i] = sc.nextInt();
				for (int j = 0; j < 256; j++)
					dpb[i][j] = false;
			}
			for (int i = 0; i < m; i++) {
				int d = addComp(128, code[i]);
				dp[0][d] = (int) Math.pow(d - sample[0], 2);
				dpb[0][d] = true;
			}
			for (int i = 0; i < n - 1; i++) {
				for (int j = 0; j < 256; j++) {
					if (dpb[i][j]) {
						for (int k = 0; k < m; k++) {
							int d = addComp(j, code[k]);
							if (dpb[i + 1][d])
								dp[i + 1][d] = Math.min(dp[i + 1][d], dp[i][j]
										+ (int) Math.pow(d - sample[i + 1], 2));
							else
								dp[i + 1][d] = dp[i][j]
										+ (int) Math.pow(d - sample[i + 1], 2);
							dpb[i + 1][d] = true;
						}
					}
				}
			}
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < 256; i++)
				if (dpb[n - 1][i])
					result = Math.min(result, dp[n - 1][i]);
			System.out.println(result);
		}
		sc.close();
	}

	static int addComp(int a, int b) {
		int r = a + b;
		r = Math.max(r, 0);
		r = Math.min(r, 255);
		return r;
	}
}
