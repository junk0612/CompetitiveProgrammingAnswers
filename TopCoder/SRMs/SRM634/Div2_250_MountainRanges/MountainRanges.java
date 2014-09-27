public class MountainRanges {

	public int countPeaks(int[] heights) {
		if (heights.length == 1)
			return 1;
		int result = 0;
		for (int i = 0; i < heights.length; i++) {
			if ((i == 0 && heights[i] > heights[i + 1])
					|| (i < heights.length - 1 && i > 0
							&& heights[i] > heights[i - 1] && heights[i] > heights[i + 1])
					|| (i == heights.length - 1 && heights[i] > heights[i - 1]))
				result++;
		}
		return result;
	}

}
