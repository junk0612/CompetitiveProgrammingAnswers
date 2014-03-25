import java.util.*;

public class When_Can_We_Meet {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			if (n == 0 && q == 0)
				break;
			int[] c = new int[101];
			for (int i = 0; i < c.length; i++) {
				c[i] = 0;
			}
			for (int i = 0; i < n; i++) {
				int m = sc.nextInt();
				for (int j = 0; j < m; j++) {
					int d = sc.nextInt();
					c[d]++;
				}
			}
			int r = 0;
			for (int i = 0; i < c.length; i++)
				if (c[r] < c[i] && c[i] >= q)
					r = i;
			System.out.println(r);
		}
		sc.close();
	}
}