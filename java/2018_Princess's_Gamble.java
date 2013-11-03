import java.util.*;

public class Princess_Gamble {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int p = sc.nextInt();
			if (n == 0 && m == 0 && p == 0)
				break;
			int[] x = new int[n];
			int sum = 0;
			for (int i = 0; i < n; i++) {
				x[i] = sc.nextInt();
				sum += x[i];
			}
			int s = sum * 100;
			s *= (100 - p);
			s /= 100;
			if (x[m - 1] != 0)
				s /= x[m - 1];
			if (x[m - 1] == 0)
				s = 0;
			System.out.println(s);
		}
		sc.close();
	}
}