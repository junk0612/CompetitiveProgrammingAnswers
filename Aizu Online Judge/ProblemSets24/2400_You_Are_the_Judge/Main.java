import java.util.*;

public class You_Are_the_Judge {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int t = sc.nextInt();
			int p = sc.nextInt();
			int r = sc.nextInt();
			if (t == 0 && p == 0 && r == 0)
				break;
			int[] co = new int[t];
			int[] pe = new int[t];
			int[][] wr = new int[t][p];
			for (int i = 0; i < t; i++) {
				co[i] = 0;
				pe[i] = 0;
				for (int j = 0; j < p; j++)
					wr[i][j] = 0;
			}
			for (int i = 0; i < r; i++) {
				int tid = sc.nextInt();
				int pid = sc.nextInt();
				int time = sc.nextInt();
				String me = sc.next();
				if (me.equals("CORRECT")) {
					co[tid - 1]++;
					pe[tid - 1] += wr[tid - 1][pid - 1] * 1200 + time;
				}
				if (me.equals("WRONG"))
					wr[tid - 1][pid - 1]++;
			}
			int[] rank = new int[t];
			for (int i = 0; i < t; i++)
				rank[i] = 1;
			for (int i = 0; i < t; i++)
				for (int j = i + 1; j < t; j++) {
					if (co[i] < co[j])
						rank[i]++;
					if (co[i] > co[j])
						rank[j]++;
					if (co[i] == co[j]) {
						if (pe[i] > pe[j])
							rank[i]++;
						if (pe[i] <= pe[j])
							rank[j]++;
					}
				}
			for (int i = 0; i < t; i++)
				for (int j = 0; j < t; j++)
					if (rank[j] == i + 1)
						System.out.println((j + 1) + " " + co[j] + " " + pe[j]);
		}
		sc.close();
	}
}
