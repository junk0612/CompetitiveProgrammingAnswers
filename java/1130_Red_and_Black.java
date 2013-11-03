import java.util.*;

public class Red_and_Black {
	static int r;
	static int w;
	static int h;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			r = 0;
			int x = 0;
			int y = 0;
			String fs;
			int[][] fi = new int[h][w];
			int[][] l = new int[h][w];
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++)
					l[i][j] = 0;
			for (int i = 0; i < h; i++) {
				fs = sc.next();
				for (int j = 0; j < w; j++) {
					if (fs.charAt(j) == '.')
						fi[i][j] = 1;
					if (fs.charAt(j) == '#')
						fi[i][j] = 0;
					if (fs.charAt(j) == '@') {
						fi[i][j] = 1;
						x = i;
						y = j;
					}
				}
			}
			loop(x, y, fi, l);
			System.out.println(r);
		}
		sc.close();
	}

	public static void loop(int x, int y, int[][] fi, int[][] l) {
		r++;
		l[x][y] = 1;
		if (x > 0)
			if (fi[x - 1][y] != 0 && l[x - 1][y] == 0)
				loop(x - 1, y, fi, l);
		if (x < h - 1)
			if (fi[x + 1][y] != 0 && l[x + 1][y] == 0)
				loop(x + 1, y, fi, l);
		if (y > 0)
			if (fi[x][y - 1] != 0 && l[x][y - 1] == 0)
				loop(x, y - 1, fi, l);
		if (y < w - 1)
			if (fi[x][y + 1] != 0 && l[x][y + 1] == 0)
				loop(x, y + 1, fi, l);
	}
}
