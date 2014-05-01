import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			boolean[][] canMeet = new boolean[30][n];
			for (int i = 0; i < 30; i++)
				for (int j = 0; j < n; j++)
					canMeet[i][j] = false;
			for (int i = 0; i < n; i++) {
				int t = sc.nextInt();
				for (int j = 0; j < t; j++) {
					canMeet[sc.nextInt() - 1][i] = true;
				}
			}
			boolean[][] hasMaps = new boolean[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					hasMaps[i][j] = false;
			for (int i = 0; i < n; i++)
				hasMaps[i][i] = true;
			int result = -1;
			for (int t = 0; t < 30; t++) {
				ArrayList<Integer> meetList = new ArrayList<Integer>();
				for (int i = 0; i < n; i++) {
					if (canMeet[t][i]) {
						meetList.add(i);
					}
				}
				Set<Integer> mapsSet = new HashSet<Integer>();
				for (Integer i : meetList) {
					for (int j = 0; j < n; j++) {
						if (hasMaps[i][j]) {
							mapsSet.add(j);
						}
					}
				}
				for (Integer i : meetList)
					for (Integer j : mapsSet) {
						hasMaps[i][j] = true;
					}
				if (mapsSet.size() == n) {
					result = t + 1;
					break;
				}
			}
			System.out.println(result);
		}
		sc.close();
	}
}
