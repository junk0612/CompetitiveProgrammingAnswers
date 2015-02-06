import java.util.Arrays;

public class OkonomiyakiParty {
	private long[][] memo = new long[60][60];

	public int count(int[] osize, int M, int K) {
		long result = 0;
		Arrays.sort(osize);
		for (long[] m : memo)
			Arrays.fill(m, -1);
		for (int i = 0; i < osize.length; i++) {
			int j = i + 1;
			while (j < osize.length && osize[j] - osize[i] <= K)
				j++;
			result = (result + combination((j - 1 - i), M - 1)) % 1000000007;
		}
		return (int) result;
	}

	private long combination(int n, int r) {
		if (n < 0 || r < 0 || n < r)
			return 0;
		if (memo[n][r] != -1)
			return memo[n][r];
		if (r == 0)
			return 1;
		return memo[n][r] = combination(n - 1, r - 1) + combination(n - 1, r);
	}
}
