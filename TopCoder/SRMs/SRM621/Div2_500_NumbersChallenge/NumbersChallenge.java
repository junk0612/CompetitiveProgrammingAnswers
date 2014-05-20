import java.util.*;

public class NumbersChallenge {

	public int MinNumber(int[] S) {
		List<Integer> result = new ArrayList<Integer>();
		for (int i = 0; i < S.length; i++) {
			int n = result.size();
			for (int j = 0; j < n; j++) {
				result.add(result.get(j) + S[i]);
			}
			result.add(S[i]);
		}
		Set<Integer> set = new HashSet<Integer>();
		set.addAll(result);
		int i = 1;
		while (!set.add(i))
			i++;
		return i;
	}

}
