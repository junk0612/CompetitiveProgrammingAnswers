public class FibonacciDiv2 {

	public int find(int N) {
		int[] fib = new int[50];
		fib[0] = 0;
		fib[1] = 1;
		for (int i = 2; i < 50; i++)
			fib[i] = fib[i - 1] + fib[i - 2];
		int i = 0;
		for (i = 1; i < 50; i++)
			if (N <= fib[i] && N > fib[i - 1])
				break;
		return Math.min(fib[i] - N, N - fib[i - 1]);
	}

}
