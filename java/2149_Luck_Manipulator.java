import java.util.*;

public class Luck_Manipulator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int x = sc.nextInt();
			if (n == 0 && a == 0 && b == 0 && c == 0 && x == 0)
				break;
			int[] y = new int[n];
			for (int i = 0; i < n; i++)
				y[i] = sc.nextInt();
			int f = 0;
			for (int i = 0; i < n; i++) {
				while (x != y[i] && f < 10001) {
					x = (a * x + b) % c;
					f++;
				}
				if (f > 10000) {
					f = -1;
					break;
				}
				if (i < n - 1 && x == y[i + 1]) {
					x = (a * x + b) % c;
					f++;
				}
			}
			System.out.println(f);
		}
		sc.close();
	}
}