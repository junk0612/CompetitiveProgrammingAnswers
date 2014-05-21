import java.util.*;

public class Dessert_Witch {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] field = new char[8][8];
		for (int i = 0; i < 8; i++) {
			String str = sc.next();
			char[] c = str.toCharArray();
			for (int j = 0; j < str.length(); j++) {
				field[i][j] = c[j];
			}
		}
		char turn = 'o';
		int[] result = { 0, 0, 0 };
		boolean opassed = false;
		boolean xpassed = false;
		do {
			Arrays.fill(result, 0);
			char[][] tfield = new char[8][8];
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 8; j++)
					tfield[i][j] = field[i][j];
			int a = count(field, turn);
			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 8; j++) {
					if (tfield[i][j] == '.')
						move(tfield, turn, i, j);
					int b = count(tfield, turn);
					if (b - a > Math.max(result[0], 1)) {
						result[0] = b - a;
						result[1] = j;
						result[2] = i;
					} else if (result[0] > 1 && b - a == result[0]) {
						if (turn == 'o') {
							if (i < result[2]
									|| (i == result[2] && j < result[1])) {
								result[1] = j;
								result[2] = i;
							}
						}
						if (turn == 'x') {
							if (i > result[2]
									|| (i == result[2] && j > result[1])) {
								result[1] = j;
								result[2] = i;
							}
						}
					}
					for (int k = 0; k < 8; k++)
						for (int l = 0; l < 8; l++)
							tfield[k][l] = field[k][l];
				}
			if (result[0] > 1) {
				move(field, turn, result[2], result[1]);
				if (turn == 'o')
					opassed = false;
				if (turn == 'x')
					xpassed = false;
			} else {
				if (turn == 'o')
					opassed = true;
				if (turn == 'x')
					xpassed = true;
			}
			if (turn == 'o')
				turn = 'x';
			else
				turn = 'o';
		} while (!(opassed && xpassed));
		printfield(field);
		sc.close();
	}

	static void printfield(char[][] field) {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++)
				System.out.print(field[i][j]);
			System.out.println();
		}
	}

	static int count(char[][] field, char turn) {
		int result = 0;
		for (int i = 0; i < 8; i++)
			for (int j = 0; j < 8; j++)
				if (field[i][j] == turn)
					result++;
		return result;
	}

	static void move(char[][] field, char turn, int x, int y) {
		int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
		int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };
		field[x][y] = turn;
		for (int i = 0; i < dx.length; i++) {
			if (x + dx[i] >= 0 && x + dx[i] < 8 && y + dy[i] >= 0
					&& y + dy[i] < 8) {
				if ((turn == 'o' && field[x + dx[i]][y + dy[i]] == 'x')
						|| (turn == 'x' && field[x + dx[i]][y + dy[i]] == 'o')) {
					for (int j = 2; j < 8; j++) {
						if (x + j * dx[i] >= 0 && x + j * dx[i] < 8
								&& y + j * dy[i] >= 0 && y + j * dy[i] < 8) {
							if (field[x + j * dx[i]][y + j * dy[i]] == '.')
								break;
							if (field[x][y] == field[x + j * dx[i]][y + j
									* dy[i]]) {
								for (int k = 1; k < j; k++)
									field[x + k * dx[i]][y + k * dy[i]] = field[x][y];
								break;
							}
						}
					}
				}
			}
		}
	}
}
