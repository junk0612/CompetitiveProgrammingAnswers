import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean[] prime = new boolean[300000];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		for (int i = 0; i < prime.length; i++)
			if (prime[i])
				for (int j = i * 2; j < prime.length; j += i)
					prime[j] = false;
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			int result = 0;
			for (int i = n + 1; i <= 2 * n; i++)
				if (prime[i])
					result++;
			System.out.println(result);
		}
		scanner.close();
	}
}
