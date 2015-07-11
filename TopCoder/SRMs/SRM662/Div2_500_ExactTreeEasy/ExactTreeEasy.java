import java.util.ArrayList;
import java.util.List;

public class ExactTreeEasy {

	public int[] getTree(int n, int m) {
		List<Integer> ret = new ArrayList<Integer>();
		for (int i = 0; i < n - m; i++) {
			ret.add(i);
			ret.add(i + 1);
		}
		for (int i = n - m + 1; i < n; i++) {
			ret.add(n - m);
			ret.add(i);
		}
		int[] r = new int[ret.size()];
		for (int i = 0; i < ret.size(); i++)
			r[i] = ret.get(i);
		return r;
	}

}
