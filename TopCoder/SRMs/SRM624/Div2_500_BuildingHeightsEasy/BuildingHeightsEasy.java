import java.util.Arrays;

public class BuildingHeightsEasy {

	public int minimum(int M, int[] heights) {
		Arrays.sort(heights);
		int result = Integer.MAX_VALUE;
		for (int i = M; i <= heights.length; i++) {
			int sum = 0;
			for (int j = i - M; j < i; j++) {
				sum += heights[i - 1] - heights[j];
			}
			result = Math.min(sum, result);
		}
		return result;
	}

}
