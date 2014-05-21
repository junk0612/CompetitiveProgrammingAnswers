import java.util.*;

public class Prime_Gap {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] prime = new boolean[1300000];
		prime[0] = false;
		prime[1] = false;
		for (int i = 2; i < prime.length; i++)
			prime[i] = true;

		for (int i = 0; i < prime.length; i++)
			if (prime[i])
				for (int j = i * 2; j < prime.length; j += i)
					prime[j] = false;

		while (true) {
			int k = sc.nextInt();
			if (k == 0)
				break;
			int l = 0, r = 0;
			for (int i = k; i > 0; i--)
				if (prime[i]) {
					l = i;
					break;
				}
			for (int i = k; i < prime.length; i++)
				if (prime[i]) {
					r = i;
					break;
				}
			int n = r - l;
			System.out.println(n);
		}
		sc.close();
	}
}
