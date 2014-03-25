import java.util.*;

public class Analyzing_Login_Logout_Records {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == 0 && m == 0)
				break;
			int[][] pc = new int[n][1440];
			int[] pctime = new int[n];
			for (int i = 0; i < n; i++) {
				pctime[i] = 0;
				for (int j = 0; j < 1440; j++)
					pc[i][j] = 0;
			}
			int r = sc.nextInt();
			for (int i = 0; i < r; i++) {
				int t = sc.nextInt();
				int ni = sc.nextInt();
				int mi = sc.nextInt();
				int s = sc.nextInt();
				if (s == 1)
					pctime[ni - 1] = t;
				if (s == 0) {
					for (int j = pctime[ni - 1]; j < t; j++)
						pc[ni - 1][j] = mi;
				}
			}
			int q = sc.nextInt();
			for (int i = 0; i < q; i++) {
				int ts = sc.nextInt();
				int te = sc.nextInt();
				int mi = sc.nextInt();
				int result = 0;
				for (int j = ts; j < te; j++)
					for (int k = 0; k < n; k++)
						if (pc[k][j] == mi) {
							result++;
							break;
						}
				System.out.println(result);
			}
		}
		sc.close();
	}
}
