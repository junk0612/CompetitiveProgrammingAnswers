import java.util.*;

public class Save_Your_Privacy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			boolean r[][] = new boolean[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					r[i][j] = false;
			for (int i = 0; i < n; i++) {
				int m = sc.nextInt();
				for (int j = 0; j < m; j++) {
					int p = sc.nextInt();
					r[i][p - 1] = true;
				}
			}
			int k = sc.nextInt();
			boolean[] result = new boolean[n];
			for (int i = 0; i < n; i++)
				result[i] = true;
			for (int i = 0; i < k; i++) {
				int l = sc.nextInt();
				for (int j = 0; j < n; j++)
					result[j] = result[j] && r[j][l - 1];
			}
			int a = -1;
			for (int i = 0; i < n; i++) {
				if (result[i]) {
					if (a != -1) {
						a = -1;
						break;
					}
					a = i + 1;
				}
			}
			System.out.println(a);
		}
		sc.close();
	}
}
