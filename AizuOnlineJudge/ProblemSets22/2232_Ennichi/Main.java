// Ennichi
import java.util.Scanner;

public class Main {
	private int h, w, n;
	private char[][] field;

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		h = sc.nextInt();
		w = sc.nextInt();
		n = sc.nextInt();
		field = new char[h][w];

		for (int i = 0; i < h; i++)
			field[i] = sc.next().toCharArray();

		boolean win = false;
		out: for (int i = 0; i < h; i++)
			for (int j = 0; j < w - 1; j++) {
				char[][] tfield = new char[h][w];
				boolean[][] bfield = new boolean[h][w];
				change(j, i, tfield);
				fall(tfield);
				while (canVanish(tfield, bfield)) {
					vanish(tfield, bfield);
					fall(tfield);
				}
				if (isBlank(tfield)) {
					win = true;
					break out;
				}
			}
		if (win) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		sc.close();
	}

	private void change(int x, int y, char[][] tfield) {
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				tfield[i][j] = field[i][j];
		char t = tfield[y][x];
		tfield[y][x] = tfield[y][x + 1];
		tfield[y][x + 1] = t;
	}

	private boolean canVanish(char[][] tfield, boolean[][] bfield) {
		if (isBlank(tfield))
			return false;
		boolean ret = false;
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++) {
				char c = tfield[i][j];
				if (c == '.')
					continue;
				if (i <= h - n) {
					boolean b = true;
					for (int k = 1; k < n; k++) {
						b = b && tfield[i + k][j] == c;
					}
					if (b) {
						ret = true;
						for (int k = 0; k < n; k++) {
							bfield[i + k][j] = true;
						}
					}
				}
				if (j <= w - n) {
					boolean b = true;
					for (int k = 1; k < n; k++) {
						b = b && tfield[i][j + k] == c;
					}
					if (b) {
						ret = true;
						for (int k = 0; k < n; k++) {
							bfield[i][j + k] = true;
						}
					}
				}
			}
		return ret;
	}

	private void vanish(char[][] tfield, boolean[][] bfield) {
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				if (bfield[i][j]) {
					tfield[i][j] = '.';
					bfield[i][j] = false;
				}
	}

	private void fall(char[][] tfield) {
		for (int j = 0; j < w; j++) {
			int height = h - 1;
			for (int i = h - 1; i >= 0; i--) {
				if (tfield[i][j] != '.') {
					if (i != height) {
						tfield[height][j] = tfield[i][j];
						tfield[i][j] = '.';
					}
					height--;
				}
			}
		}
	}

	private boolean isBlank(char[][] tfield) {
		for (int i = 0; i < w; i++)
			if (tfield[h - 1][i] != '.')
				return false;
		return true;
	}

}
