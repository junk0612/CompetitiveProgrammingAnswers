import java.util.*;

public class Calender_Colors {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		double[][] colors = new double[n][3];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 3; j++)
				colors[i][j] = sc.nextDouble();
		}
		double result = 0;
		for (int i = (1 << m) - 1; i < 1 << n; i++)
			if (Integer.bitCount(i) == m) {
				result = Math.max(result, calc(i, m, colors));
			}
		System.out.println(result);
		sc.close();
	}

	static double calc(int i, int m, double[][] colors) {
		int counter = 0;
		double result = 0;
		double[][] v = new double[m][3];
		for (int j = 0; j < colors.length; j++)
			if ((i & 1 << j) != 0) {
				v[counter] = colors[j];
				counter++;
			}
		for (int j = 0; j < v.length; j++)
			for (int k = j + 1; k < v.length; k++) {
				double[] d = { v[j][0] - v[k][0], v[j][1] - v[k][1],
						v[j][2] - v[k][2] };
				result += d[0] * d[0] + d[1] * d[1] + d[2] * d[2];
			}
		return result;
	}
}