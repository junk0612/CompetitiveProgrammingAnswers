import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Egalitarianism3 {

	public int maxCities(int n, int[] a, int[] b, int[] len) {
		System.out.println("--");
		if (n == 1)
			return 1;
		int[][] lengths = new int[n][n];
		for (int i = 0; i < a.length; i++) {
			lengths[a[i] - 1][b[i] - 1] = len[i];
			lengths[b[i] - 1][a[i] - 1] = len[i];
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				System.out.print(lengths[i][j]);
			System.out.println();
		}
		List<Integer> list = new ArrayList<Integer>();
		int result = 1;
		for (int i = 0; i < n; i++) {
			list.clear();
			for (int j = 0; j < n; j++)
				if (lengths[i][j] > 0)
					list.add(lengths[i][j]);
			Collections.sort(list);
			for (int j : list)
				System.out.print(j + ",");
			System.out.println();
			int k = 1;
			int r = list.remove(0);
			while (!list.isEmpty()) {
				System.out.println(k);
				int tr = list.remove(0);
				if (tr == r)
					k++;
				else {
					r = tr;
					result = Math.max(k, result);
				}
			}
			result = Math.max(k, result);
		}
		return result;
	}

}
