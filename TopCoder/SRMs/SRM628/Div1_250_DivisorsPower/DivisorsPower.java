public class DivisorsPower {

	public long findArgument(long n) {
		long mat = 1L << 60;
		double sq = Math.sqrt(n);

		for (long x = (long) sq - 3; x <= sq + 3; x++)
			if (x >= 2 && x * x == n && enumdiv(x) == 2)
				mat = x;

		for (long x = 2; x <= 1000000; x++) {
			long y = x, pp = 1;
			while (y * x <= n && y * x / x == y) {
				y *= x;
				pp++;
			}
			if (y != n || pp == 1)
				continue;
			if (pp == enumdiv(x))
				mat = Math.min(mat, x);
		}

		if (mat >= 1L << 60)
			return -1;
		return mat;
	}

	int enumdiv(long n) {
		int ret = 0;
		for (long i = 1; i * i <= n; i++)
			if (n % i == 0)
				ret += 1 + (i * i != n ? 1 : 0);
		return ret;
	}

}
