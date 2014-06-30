public class FixedDiceGameDiv2 {

	public double getExpectation(int a, int b) {
		double result = 0;
		int count = 0;
		for (int i = 1; i <= a; i++)
			for (int j = 1; j <= b; j++)
				if (i > j) {
					result += i;
					count++;
				}
		return result / count;
	}

}
