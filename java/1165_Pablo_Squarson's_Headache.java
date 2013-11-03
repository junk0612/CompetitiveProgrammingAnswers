import java.util.*;

public class Pablo_Squarson_Headache {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int[] x = new int[n];
			int[] y = new int[n];
			x[0] = 0;
			y[0] = 0;
			for (int i = 1; i < n; i++) {
				int p = sc.nextInt();
				int d = sc.nextInt();
				switch (d) {
				case 0:
					x[i] = x[p] - 1;
					y[i] = y[p];
					break;
				case 1:
					x[i] = x[p];
					y[i] = y[p] - 1;
					break;
				case 2:
					x[i] = x[p] + 1;
					y[i] = y[p];
					break;
				case 3:
					x[i] = x[p];
					y[i] = y[p] + 1;
					break;
				}
			}
			int xmax = 0, xmin = 0, ymax = 0, ymin = 0;
			for (int i = 1; i < n; i++) {
				xmax = Math.max(xmax, x[i]);
				xmin = Math.min(xmin, x[i]);
				ymax = Math.max(ymax, y[i]);
				ymin = Math.min(ymin, y[i]);
			}
			int w = xmax - xmin + 1;
			int h = ymax - ymin + 1;
			System.out.println(w + " " + h);
		}
		sc.close();
	}
}
