public class BoxesDiv2 {

	public int findSize(int[] candyCounts) {
		int sum = 0;
		for (int i = 0; i < candyCounts.length; i++) {
			sum += changetwices(candyCounts[i]);
		}
		return changetwices(sum);
	}

	private int changetwices(int n) {
		int i = 1;
		while (i < n)
			i *= 2;
		return i;
	}
}
