import java.util.*;

public class Grey_Area {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int w = sc.nextInt();
			if (n == 0 && w == 0)
				break;
			int[] app = new int[11];
			for (int i = 0; i < 11; i++)
				app[i] = 0;
			int hh = 0;
			int ww = 0;
			for (int i = 0; i < n; i++) {
				int v = sc.nextInt();
				app[v / w]++;
				hh = Math.max(hh, app[v / w]);
				ww = Math.max(ww, v / w);
			}
			double result = 0;
			for (int i = 0; i < ww; i++) {
				result += (double) app[i] / (double) hh * (double) (ww - i)
						/ (double) ww;
			}
			result += 0.01;
			System.out.println(result);
		}
		sc.close();
	}
}
