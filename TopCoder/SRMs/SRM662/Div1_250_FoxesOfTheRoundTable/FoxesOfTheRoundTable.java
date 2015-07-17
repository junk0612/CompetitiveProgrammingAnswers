import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

public class FoxesOfTheRoundTable {

	public int[] minimalDifference(int[] h) {
		int[] num = new int[h.length];
		for (int i = 0; i < h.length; i++)
			num[i] = i;
		for (int i = 0; i < h.length; i++)
			for (int j = h.length - 2; j >= i; j--)
				if (h[j] > h[j + 1]) {
					int t = h[j];
					h[j] = h[j + 1];
					h[j + 1] = t;
					t = num[j];
					num[j] = num[j + 1];
					num[j + 1] = t;
				}
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < h.length; i += 2) {
			list.add(num[i]);
		}
		for (int i = h.length / 2 * 2 - 1; i >= 0; i -= 2) {
			list.add(num[i]);
		}
		int[] result = new int[h.length];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

}
