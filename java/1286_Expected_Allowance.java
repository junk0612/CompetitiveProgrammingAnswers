public class Expected_Allowance {
	public static void main(String[] args) {
		java.util.Scanner sc = new java.util.Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int k = sc.nextInt();
			if (n == 0 && m == 0 && k == 0)
				break;
			int[] dice = new int[n];
			int[] result = new int[n * m + 1];
			java.util.Arrays.fill(dice, 1);
			out: while (true) {
				int pointer = n - 1;
				result[Math.max(1, sum(dice) - k)]++;
				if (dice[pointer] < m) {
					dice[pointer]++;
					continue;
				}
				while (dice[pointer] == m) {
					pointer--;
					if (pointer < 0)
						break out;
				}
				dice[pointer]++;
				while (pointer != n - 1) {
					pointer++;
					dice[pointer] = 1;
				}
			}
			double p = 0;
			for (int i = 0; i < result.length; i++) {
				p += (double) i * result[i] / Math.pow(m, n);
			}
			System.out.println(p);
		}
		sc.close();
	}

	static int sum(int[] dice) {
		int sum = 0;
		for (int i = 0; i < dice.length; i++)
			sum += dice[i];
		return sum;
	}
}
