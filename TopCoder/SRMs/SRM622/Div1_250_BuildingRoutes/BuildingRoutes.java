public class BuildingRoutes {

	public int build(String[] dist, int T) {
		int n = dist.length;
		int[][] dists = new int[n][n];
		int[][] costs = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				dists[i][j] = dist[i].charAt(j) - '0';
				costs[i][j] = dist[i].charAt(j) - '0';
			}
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					costs[i][j] = Math.min(costs[i][j], costs[i][k]
							+ costs[k][j]);
		int result = 0;
		for (int s = 0; s < n; s++)
			for (int g = 0; g < n; g++) {
				int count = 0;
				for (int i = 0; i < n; i++)
					for (int j = 0; j < n; j++) {
						if (i != j
								&& costs[i][s] + dists[s][g] + costs[g][j] == costs[i][j])
							count++;
					}
				if (count >= T)
					result += dists[s][g];
			}
		return result;
	}

}
