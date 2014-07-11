public class ManySquares {

	public int howManySquares(int[] sticks) {
		int[] num = new int[1001];
		for (int i = 0; i < sticks.length; i++)
			num[sticks[i]]++;
		int result = 0;
		for (int i = 0; i < num.length; i++)
			result += num[i] / 4;
		return result;
	}

}
