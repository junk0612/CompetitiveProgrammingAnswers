import java.util.*;

public class Calling_Extraterrestrial_Intelligence_Again {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] prime = new boolean[100000];
		for (int i = 0; i < prime.length; i++)
			prime[i] = true;
		for (int i = 2; i < prime.length; i++)
			if (prime[i])
				for (int j = i + i; j < prime.length; j += i)
					prime[j] = false;
		while (true) {
			int m = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			if (m == 0 && a == 0 && b == 0)
				break;
			int p = 0, q = 0;
			out: for (int i = m; i > 0; i--) {
				for (int j = 2; j < (int) Math.sqrt(i) + 1; j++) {
					if (i % j == 0 && prime[i / j] && prime[j]
							&& a * i <= b * j * j) {
						p = j;
						q = i / j;
						break out;
					}
				}
			}
			System.out.println(p + " " + q);
		}
		sc.close();
	}
}
