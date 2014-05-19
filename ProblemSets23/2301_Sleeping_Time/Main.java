// Sleeping Time
import java.util.*;

public class Main {
	static double P, E, T;
	static int K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		K = sc.nextInt();
		int R = sc.nextInt();
		int L = sc.nextInt();
		P = sc.nextDouble();
		E = sc.nextDouble();
		T = sc.nextDouble();
		System.out.printf("%.6f", search(0, (double) R, (double) L));
		System.out.println();
		sc.close();
	}

	static double search(int t, double R, double L) {
		double H = (R + L) / 2;
		if (t == K) {
			if (isIn(H))
				return 1;
			return 0;
		}
		if (L < T - E || T + E < R)
			return 0;
		if (isIn(L) && isIn(R))
			return 1;
		if (T <= H)
			return (1 - P) * search(t + 1, R, H) + P * search(t + 1, H, L);
		return (1 - P) * search(t + 1, H, L) + P * search(t + 1, R, H);
	}

	static boolean isIn(double H) {
		return Math.abs(T - H) < E;
	}
}
