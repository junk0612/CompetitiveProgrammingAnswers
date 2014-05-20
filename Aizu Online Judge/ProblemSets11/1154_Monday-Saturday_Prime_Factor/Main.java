import java.util.*;

public class Monday_Saturday_Prime_Factor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] prime = new boolean[300000];
		for (int i = 0; i < prime.length; i++)
			prime[i] = false;
		for (int i = 7; i < prime.length; i += 7) {
			prime[i - 1] = true;
			if (i + 1 < prime.length)
				prime[i + 1] = true;
		}
		for (int i = 6; i < prime.length; i++)
			if (prime[i])
				for (int j = i * 2; j < prime.length; j += i)
					prime[j] = false;
		while (true) {
			int n = sc.nextInt();
			if (n == 1)
				break;
			System.out.print(n + ":");
			for (int i = 0; i < prime.length; i++)
				if (prime[i] && n % i == 0)
					System.out.print(" " + i);
			System.out.println();
		}
		sc.close();
	}
}
