import java.util.*;

public class Infected_Computer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			if (n == 0 && m == 0)
				break;
			boolean[] inf = new boolean[n];
			inf[0] = true;
			for (int i = 1; i < inf.length; i++)
				inf[i] = false;
			int[] t = new int[m];
			int[] dt = new int[m];
			int[] s = new int[m];
			int[] d = new int[m];
			for (int i = 0; i < m; i++) {
				t[i] = sc.nextInt();
				dt[i] = t[i];
				s[i] = sc.nextInt() - 1;
				d[i] = sc.nextInt() - 1;
			}
			Arrays.sort(dt);
			for (int i = 0; i < m; i++)
				for (int j = 0; j < m; j++)
					if (t[j] == dt[i] && inf[s[j]] && !inf[d[j]])
						inf[d[j]] = true;
			int result = 0;
			for (int i = 0; i < inf.length; i++)
				if (inf[i])
					result++;
			System.out.println(result);
		}
		sc.close();
	}
}
