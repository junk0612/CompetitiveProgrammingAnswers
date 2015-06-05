import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int[] signals = new int[n];
			int count = 0;
			for (int i = 0; i < n; i++) {
				try {
					signals[i] = sc.nextInt();
				} catch (InputMismatchException e) {
					signals[i] = Integer.MAX_VALUE;
					sc.next();
					count++;
				}
			}
			int min = Integer.MIN_VALUE;
			int max = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (signals[i] == Integer.MAX_VALUE) {
					if (i % 2 == 0) {
						if (i > 0) {
							max = Math.min(max, signals[i - 1]);
						}
						if (i < n - 1) {
							max = Math.min(max, signals[i + 1]);
						}
					} else {
						min = Math.max(min, signals[i - 1]);
						if (i < n - 1) {
							min = Math.max(min, signals[i + 1]);
						}
					}
				}
			}
			if (max - min == 2) {
				boolean isNone = false;
				for (int i = 0; i < n; i++) {
					if (signals[i] == Integer.MAX_VALUE) {
						signals[i] = max - 1;
					}
					if (i > 0) {
						if ((i % 2 == 0 && signals[i - 1] <= signals[i])
								|| (i % 2 == 1 && signals[i - 1] >= signals[i])) {
							isNone = true;
							break;
						}
					}
				}
				if (isNone) {
					System.out.println("none");
				} else {
					System.out.println((max + min) / 2);
				}
			} else if (count == 1) {
				System.out.println("ambiguous");
			} else {
				boolean isNone = false;
				for (int i = 0; i < n; i++) {
					if (signals[i] == Integer.MAX_VALUE) {
						signals[i] = max - 1;
					}
					if (i > 0) {
						if ((i % 2 == 0 && signals[i - 1] <= signals[i])
								|| (i % 2 == 1 && signals[i - 1] >= signals[i])) {
							isNone = true;
							break;
						}
					}
				}
				if (isNone) {
					System.out.println("none");
				} else {
					System.out.println("ambiguous");
				}
			}
		}
		sc.close();
	}

}
