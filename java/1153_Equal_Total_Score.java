import java.util.Arrays;
import java.util.Scanner;

public class Equal_Total_Score {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int result = -1;
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == 0 && m == 0)
				break;
			int[] ns = new int[n];
			int[] ms = new int[m];
			for (int i = 0; i < n; i++)
				ns[i] = sc.nextInt();
			for (int i = 0; i < m; i++)
				ms[i] = sc.nextInt();
			Arrays.sort(ns);
			Arrays.sort(ms);
			int nsum = 0, msum = 0;
			for (int i = 0; i < n; i++)
				nsum += ns[i];
			for (int i = 0; i < m; i++)
				msum += ms[i];
			out: for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++) {
					if (nsum - ns[i] + ms[j] == msum - ms[j] + ns[i]) {
						System.out.println(ns[i] + " " + ms[j]);
						result = 1;
						break out;
					}
				}
			if (result == -1)
				System.out.println(result);
		}
		sc.close();
	}
}
