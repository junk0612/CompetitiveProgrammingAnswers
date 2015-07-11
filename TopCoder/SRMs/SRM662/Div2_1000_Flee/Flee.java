public class Flee {

	public double maximalSafetyLevel(int[] x, int[] y) {
		if (x.length == 1)
			return Math.sqrt(x[0] * x[0] + y[0] * y[0]);
		if (x.length == 2)
			return Math.min(Math.sqrt(x[0] * x[0] + y[0] * y[0]),
					Math.sqrt(x[1] * x[1] + y[1] * y[1]));
		double ret = Double.MAX_VALUE;
		double side = 0;
		int[] cross = new int[x.length];
		for (int i = 0; i < x.length; i++) {
			ret = Math.min(ret, Math.sqrt(x[i] * x[i] + y[i] * y[i]));
			side = Math
					.max(side,
							Math.sqrt(((x[i] - x[(i + 1) % x.length]) * (x[i] - x[(i + 1)
									% x.length]))
									+ ((y[i] - y[(i + 1) % y.length]) * (y[i] - y[(i + 1)
											% y.length]))));
			cross[i] = new Vector(x[i], y[i]).cross(new Vector(x[i]
					- x[(i + 1) % x.length], y[i] - y[(i + 1) % y.length]));
		}
		if ((cross[0] < 0 && cross[1] < 0 && cross[2] < 0)
				|| (cross[0] > 0 && cross[1] > 0 && cross[2] > 0))
			ret = Math.min(ret, side / 2);
		return ret;
	}
}

class Vector {
	int x;
	int y;

	Vector(int x, int y) {
		this.x = x;
		this.y = y;
	}

	int cross(Vector anotherVector) {
		return this.x * anotherVector.y - this.y * anotherVector.x;
	}
}