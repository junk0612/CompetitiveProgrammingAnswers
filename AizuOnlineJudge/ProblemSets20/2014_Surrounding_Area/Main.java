import java.util.*;

public class Surrounding_Area {
	static char[][] field;
	static int w;
	static int h;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			field = new char[h][w];
			for (int i = 0; i < h; i++) {
				String str = sc.next();
				for (int j = 0; j < w; j++)
					field[i][j] = str.charAt(j);
			}
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++)
					if (field[i][j] != '.')
						check(j, i);
			int black = 0;
			int white = 0;
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++) {
					if (field[i][j] == 'b')
						black++;
					if (field[i][j] == 'w')
						white++;
				}
			System.out.println(black + " " + white);
		}
		sc.close();
	}

	static void check(int x, int y) {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		for (int i = 0; i < 4; i++) {
			switch (field[y][x]) {
			case 'W':
			case 'w':
				if (x + dx[i] >= 0 && x + dx[i] < w && y + dy[i] >= 0
						&& y + dy[i] < h)
					switch (field[y + dy[i]][x + dx[i]]) {
					case '.':
						field[y + dy[i]][x + dx[i]] = 'w';
						check(x + dx[i], y + dy[i]);
						break;
					case 'b':
						field[y + dy[i]][x + dx[i]] = 'n';
						check(x + dx[i], y + dy[i]);
						break;
					}
				break;
			case 'B':
			case 'b':
				if (x + dx[i] >= 0 && x + dx[i] < w && y + dy[i] >= 0
						&& y + dy[i] < h)
					switch (field[y + dy[i]][x + dx[i]]) {
					case '.':
						field[y + dy[i]][x + dx[i]] = 'b';
						check(x + dx[i], y + dy[i]);
						break;
					case 'w':
						field[y + dy[i]][x + dx[i]] = 'n';
						check(x + dx[i], y + dy[i]);
						break;
					}
				break;
			case 'n':
				if (x + dx[i] >= 0 && x + dx[i] < w && y + dy[i] >= 0
						&& y + dy[i] < h)
					switch (field[y + dy[i]][x + dx[i]]) {
					case '.':
					case 'b':
					case 'w':
						field[y + dy[i]][x + dx[i]] = 'n';
						check(x + dx[i], y + dy[i]);
						break;
					}
				break;
			}
		}
	}
}
