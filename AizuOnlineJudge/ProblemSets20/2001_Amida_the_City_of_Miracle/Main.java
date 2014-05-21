import java.util.*;

public class Amida_the_City_of_Miracle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int a = sc.nextInt();
			if (n == 0 && m == 0 && a == 0)
				break;
			int[] amida = new int[n];
			for (int i = 0; i < n; i++)
				amida[i] = i;
			int[] h = new int[m];
			int[] p = new int[m];
			int[] q = new int[m];
			int max = 0;
			for (int i = 0; i < m; i++) {
				h[i] = sc.nextInt();
				p[i] = sc.nextInt();
				q[i] = sc.nextInt();
				max = Math.max(max, h[i]);
			}
			for (int i = max - 1; i >= 0; i--)
				for (int j = 0; j < m; j++)
					if (h[j] == i + 1) {
						int t = amida[p[j] - 1];
						amida[p[j] - 1] = amida[q[j] - 1];
						amida[q[j] - 1] = t;
					}
			for (int i = 0; i < n; i++)
				if (amida[i] == a - 1) {
					System.out.println(i + 1);
					break;
				}
		}
		sc.close();
	}
}