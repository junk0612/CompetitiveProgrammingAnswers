public class FixedDiceGameDiv1 {

	public double getExpectation(int a, int b, int c, int d) {
		if (a * b <= c)
			return -1;
		double[][] dpAlice = new double[a + 1][a * b + 1];
		double[][] dpBob = new double[c + 1][c * d + 1];
		dpAlice[0][0] = 1;
		dpBob[0][0] = 1;
		for (int i = 0; i < a; i++)
			for (int j = 0; j <= a * b; j++)
				for (int k = 1; j + k <= a * b; k++)
					dpAlice[i + 1][j + k] += dpAlice[i][j] / b;
		for (int i = 0; i < c; i++)
			for (int j = 0; j <= c * d; j++)
				for (int k = 1; j + k <= c * d; k++)
					dpBob[i + 1][j + k] += dpBob[i][j] / d;
		double sum = 0;
		for (int j = 0; j < c * d + 1; j++) {
			sum += dpBob[c][j];
			dpBob[c][j] = sum;
		}
		double result = 0;
		double win = 0;
		for (int i = 0; i <= a * b; i++)
			for (int j = 0; j <= c * d; j++)
				if (i > j) {
					win += dpAlice[a][i] * dpBob[c][j];
					result += i * dpAlice[a][i] * dpBob[c][j];
				}
		return result / win;
	}

}
