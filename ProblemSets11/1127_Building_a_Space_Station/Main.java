// Building a Space Station
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			Point[] points = new Point[n];
			for (int i = 0; i < n; i++) {
				double x = scanner.nextDouble();
				double y = scanner.nextDouble();
				double z = scanner.nextDouble();
				double r = scanner.nextDouble();
				points[i] = new Point(x, y, z, r);
			}
			double[][] costs = new double[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					double d = points[i].distance(points[j]);
					costs[i][j] = d;
				}
			boolean[] selected = new boolean[n];
			Arrays.fill(selected, false);
			selected[0] = true;
			double result = 0;
			while (!trueAll(selected)) {
				double cost = Double.MAX_VALUE;
				int dst = 0;
				for (int i = 0; i < n; i++) {
					if (selected[i]) {
						for (int j = 0; j < n; j++) {
							if (!selected[j] && cost > costs[i][j]) {
								cost = costs[i][j];
								dst = j;
							}
						}
					}
				}
				result += cost;
				selected[dst] = true;
			}
			System.out.printf("%.3f", result);
			System.out.println();
		}
		scanner.close();
	}

	static boolean trueAll(boolean[] selected) {
		boolean result = true;
		for (boolean b : selected) {
			result = result && b;
		}
		return result;
	}
}

class Point {
	double x, y, z, r;

	Point(double tx, double ty, double tz, double tr) {
		x = tx;
		y = ty;
		z = tz;
		r = tr;
	}

	public double distance(Point anotherPoint) {
		double dx = this.x - anotherPoint.x;
		double dy = this.y - anotherPoint.y;
		double dz = this.z - anotherPoint.z;
		double d2 = Math.pow(dx, 2) + Math.pow(dy, 2) + Math.pow(dz, 2);
		double d = Math.sqrt(d2);
		double cost = d - this.r - anotherPoint.r;
		return Math.max(cost, 0);
	}
}