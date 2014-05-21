import java.util.*;

public class How_Many_Islands {
	static int w;
	static int h;
	static int[][] fi;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			fi = new int[h][w];
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++)
					fi[i][j] = sc.nextInt();
			int n = 0;
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++)
					if (fi[i][j] == 1)
						n += loop(j, i);
			System.out.println(n);
		}
		sc.close();
	}

	public static int loop(int x, int y) {
		fi[y][x] = 0;
		int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };
		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && nx < w && ny >= 0 && ny < h) {
				if (fi[ny][nx] == 1)
					loop(nx, ny);
			}
		}
		return 1;
	}
}