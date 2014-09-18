import java.util.ArrayList;
import java.util.List;

public class PotentialArithmeticSequence {

	public int numberOfSubsequences(int[] d) {
		int L = 0, R = 0;
		int result = 0;
		List<Integer> list = new ArrayList<Integer>();
		while (true) {
			list.clear();
			for (int i = L; i <= R; i++)
				list.add(d[i]);
			if (check(list)) {
				result -= sumOf(R - L);
				result += sumOf(R - L + 1);
				if (R == d.length - 1)
					break;
				R++;
				continue;
			}
			if (R == d.length - 1 && L == R)
				break;
			L++;
			if (R < L)
				R++;
		}
		return result;
	}

	private int sumOf(int i) {
		return i * (i + 1) / 2;
	}

	private boolean check(List<Integer> list) {
		if (list.size() == 1)
			return true;
		if (list.get(0) != 0) {
			for (int i = 0; i < list.size(); i++)
				if ((i % 2 == 0 && list.get(i) == 0)
						|| (i % 2 == 1 && list.get(i) != 0))
					return false;
		} else {
			for (int i = 0; i < list.size(); i++)
				if ((i % 2 == 0 && list.get(i) != 0)
						|| (i % 2 == 1 && list.get(i) == 0))
					return false;
		}
		List<Integer> newList = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) != 0)
				newList.add(list.get(i) - 1);
		}
		return check(newList);
	}

}
