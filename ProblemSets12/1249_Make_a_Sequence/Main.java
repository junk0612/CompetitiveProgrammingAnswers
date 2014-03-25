import java.util.*;

public class Make_a_Sequence {
	static int[][][] field;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int p = sc.nextInt();
			if (n == 0 && m == 0 && p == 0)
				break;
			field = new int[n][n][n];
			String winner = "Draw";
			int turn = 0;
			for (int i = 0; i < p; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				move(x, y, i, n);
				if (winner.equals("Draw") && checkEnd(n, m) != 0) {
					if (checkEnd(n, m) == 1)
						winner = "Black";
					else
						winner = "White";
					turn = i + 1;
				}
				// printField(n);
			}
			if (winner.equals("Draw"))
				System.out.println(winner);
			else
				System.out.println(winner + " " + turn);
		}
		sc.close();
	}

	static void move(int x, int y, int turn, int n) {
		for (int i = 0; i < n; i++)
			if (field[x][y][i] == 0) {
				field[x][y][i] = turn % 2 + 1;
				break;
			}
	}

	static int checkEnd(int n, int m) {
		int[] dx = { -1, 0, 1 };
		int[] dy = { -1, 0, 1 };
		int[] dz = { -1, 0, 1 };
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				for (int k = 0; k < n; k++)
					if (field[i][j][k] != 0)
						for (int a = 0; a < dx.length; a++)
							for (int b = 0; b < dx.length; b++)
								for (int c = 0; c < dx.length; c++) {
									if (i + dx[a] * (m - 1) >= 0
											&& i + dx[a] * (m - 1) < n
											&& j + dy[b] * (m - 1) >= 0
											&& j + dy[b] * (m - 1) < n
											&& k + dz[c] * (m - 1) >= 0
											&& k + dz[c] * (m - 1) < n) {
										boolean x = true;
										if (dx[a] == 0 && dy[b] == 0
												&& dz[c] == 0)
											x = false;
										else
											for (int l = 1; l < m; l++)
												x = x
														&& (field[i][j][k] == field[i
																+ dx[a] * l][j
																+ dy[b] * l][k
																+ dz[c] * l]);
										if (x)
											return field[i][j][k];
									}
								}
		return 0;
	}

	static void printField(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++)
					System.out.print(field[k][i][j] + " ");
				System.out.println();
			}
			System.out.println();
		}
	}
}
