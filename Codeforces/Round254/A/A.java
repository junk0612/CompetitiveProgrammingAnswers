import java.util.Scanner;

public class A {
	static int n, m;
	static char[][] field;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		field = new char[n][m];
		for (int i = 0; i < n; i++)
			field[i] = sc.next().toCharArray();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (field[i][j] == '.')
					search(j, i, 'B');
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				System.out.print(field[i][j]);
			System.out.println();
		}
		sc.close();
	}

	static void search(int x, int y, char c) {
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, -1, 0, 1 };
		field[y][x] = c;
		for (int i = 0; i < dx.length; i++) {
			if (isIn(x + dx[i], y + dy[i])
					&& field[y + dy[i]][x + dx[i]] == '.') {
				if (c == 'B')
					search(x + dx[i], y + dy[i], 'W');
				else
					search(x + dx[i], y + dy[i], 'B');
			}
		}
	}

	static boolean isIn(int x, int y) {
		return x >= 0 && x < m && y >= 0 && y < n;
	}
}
