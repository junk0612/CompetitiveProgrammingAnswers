public class SumOfPower {

	public int findSum(int[] array) {
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			int tsum = 0;
			for (int j = i; j < array.length; j++) {
				tsum += array[j];
				sum += tsum;
			}
		}
		return sum;
	}

}
