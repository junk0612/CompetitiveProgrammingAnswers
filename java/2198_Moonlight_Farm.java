import java.util.*;

public class Moonlight_Farm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			String[] l = new String[n];
			int[] p = new int[n];
			int[] a = new int[n];
			int[] b = new int[n];
			int[] c = new int[n];
			int[] d = new int[n];
			int[] e = new int[n];
			int[] f = new int[n];
			int[] s = new int[n];
			int[] m = new int[n];
			for (int i = 0; i < n; i++) {
				l[i] = sc.next();
				p[i] = sc.nextInt();
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
				c[i] = sc.nextInt();
				d[i] = sc.nextInt();
				e[i] = sc.nextInt();
				f[i] = sc.nextInt();
				s[i] = sc.nextInt();
				m[i] = sc.nextInt();
			}
			int[] bef = new int[n];
			int[] aft = new int[n];
			for (int i = 0; i < n; i++) {
				bef[i] = a[i] + b[i] + c[i];
				aft[i] = d[i] + e[i];
			}
			int[] time = new int[n];
			int[] amount = new int[n];
			for (int i = 0; i < n; i++) {
				time[i] = bef[i] + m[i] * aft[i];
				amount[i] = m[i] * f[i] * s[i] - p[i];
			}
			double[] per = new double[n];
			for (int i = 0; i < n; i++)
				per[i] = (double) amount[i] / (double) time[i];
			int[] rank = new int[n];
			for (int i = 0; i < n; i++)
				rank[i] = 1;
			for (int i = 0; i < n; i++)
				for (int j = i + 1; j < n; j++) {
					if (per[i] > per[j])
						rank[j]++;
					if (per[i] < per[j])
						rank[i]++;
					if (per[i] == per[j]) {
						if (l[i].compareTo(l[j]) < 0)
							rank[j]++;
						if (l[i].compareTo(l[j]) > 0)
							rank[i]++;
					}
				}
			for (int i = 1; i < n + 1; i++)
				for (int j = 0; j < n; j++)
					if (rank[j] == i)
						System.out.println(l[j]);
			System.out.println("#");
		}
		sc.close();
	}
}
