import java.util.Arrays;

public class BuildingHeights {

	public int minimum(int[] heights) {
		Arrays.sort(heights);
		int[] result = new int[heights.length];
		Arrays.fill(result, Integer.MAX_VALUE);
		for (int M = 2; M <= heights.length; M++) {
			for (int i = M; i <= heights.length; i++) {
				int sum = 0;
				for (int j = i - M; j < i; j++) {
					sum += heights[i - 1] - heights[j];
				}
				result[M - 1] = Math.min(sum, result[M - 1]);
			}
		}
		int ret = 0;
		for (int i = 1; i < heights.length; i++)
			ret ^= result[i];
		return ret;
	}

}
