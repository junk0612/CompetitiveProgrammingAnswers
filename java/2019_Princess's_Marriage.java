import java.util.*;

public class Princess_Marriage {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == 0 && m == 0)
				break;
			int[] d = new int[n];
			int[] p = new int[n];
			for (int i = 0; i < n; i++) {
				d[i] = sc.nextInt();
				p[i] = sc.nextInt();
			}
			int[] pr = new int[n];
			for (int i = 0; i < n; i++)
				pr[i] = p[i];
			Arrays.sort(pr);
			for (int i = n - 1; i >= 0; i--) {
				for (int j = 0; j < n; j++) {
					if (pr[i] == p[j]) {
						if (d[j] == 0)
							continue;
						if (d[j] < m) {
							m -= d[j];
							d[j] = 0;
							break;
						}
						if (d[j] >= m) {
							d[j] -= m;
							m = 0;
							break;
						}
					}
				}
				if (m == 0)
					break;
			}
			int result = 0;
			for (int i = 0; i < n; i++)
				result += p[i] * d[i];
			System.out.println(result);
		}
		sc.close();
	}
}
