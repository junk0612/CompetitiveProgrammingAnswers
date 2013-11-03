import java.util.*;

public class Brave_Force_Story {
	static int[][] field;
	static int center = 100;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int t = sc.nextInt();
			int n = sc.nextInt();
			if (t == 0 && n == 0)
				break;
			field = new int[201][201];
			for (int i = 0; i < 201; i++)
				for (int j = 0; j < 201; j++)
					field[i][j] = 0;
			int[] x = new int[n];
			int[] y = new int[n];
			for (int i = 0; i < n; i++) {
				x[i] = sc.nextInt() + center;
				y[i] = sc.nextInt() + center;
				field[x[i]][y[i]] = -1;
			}
			int sx = sc.nextInt() + center;
			int sy = sc.nextInt() + center;
			field[sx][sy] = 1;
			move(sx, sy, t);
			int result = count(201);
			System.out.println(result);
		}
		sc.close();
	}

	static void move(int x, int y, int t) {
		int[] dx = { 0, 1, 1, 0, -1, -1 };
		int[] dy = { 1, 1, 0, -1, -1, 0 };
		if (field[x][y] <= t)
			for (int i = 0; i < dx.length; i++) {
				if (field[x + dx[i]][y + dy[i]] == 0) {
					field[x + dx[i]][y + dy[i]] = field[x][y] + 1;
					move(x + dx[i], y + dy[i], t);
				}
				if (field[x + dx[i]][y + dy[i]] > 0
						&& field[x + dx[i]][y + dy[i]] > field[x][y] + 1) {
					field[x + dx[i]][y + dy[i]] = field[x][y] + 1;
					move(x + dx[i], y + dy[i], t);
				}
			}
	}

	static int count(int w) {
		int result = 0;
		for (int i = 0; i < w; i++)
			for (int j = 0; j < w; j++)
				if (field[i][j] > 0)
					result++;
		return result;
	}
}