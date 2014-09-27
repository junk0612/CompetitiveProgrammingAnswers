public class ShoppingSurveyDiv2 {

	public int minValue(int N, int[] s) {
		int result = N;
		for (int i = 0; i < s.length; i++)
			result -= N - s[i];
		return Math.max(result, 0);
	}

}
