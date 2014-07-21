import java.util.*;

public class Main {
	static int[][] J;
	static int[][] O;
	static int[][] I;
	static char[][] field;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt(), N = sc.nextInt(), K = sc.nextInt();
		field = new char[M][N];
		J = new int[M][N];
		O = new int[M][N];
		I = new int[M][N];
		for (int i = 0; i < M; i++) {
			field[i] = sc.next().toCharArray();
			for (int j = 0; j < N; j++) {
				if (i > 0) {
					J[i][j] += J[i - 1][j];
					O[i][j] += O[i - 1][j];
					I[i][j] += I[i - 1][j];
					if (j > 0) {
						J[i][j] -= J[i - 1][j - 1];
						O[i][j] -= O[i - 1][j - 1];
						I[i][j] -= I[i - 1][j - 1];
					}
				}
				if (j > 0) {
					J[i][j] += J[i][j - 1];
					O[i][j] += O[i][j - 1];
					I[i][j] += I[i][j - 1];
				}
				switch (field[i][j]) {
				case 'J':
					J[i][j]++;
					break;
				case 'O':
					O[i][j]++;
					break;
				case 'I':
					I[i][j]++;
					break;
				}
			}
		}
		for (int i = 0; i < K; i++) {
			int a = sc.nextInt() - 1, b = sc.nextInt() - 1, c = sc.nextInt() - 1, d = sc
					.nextInt() - 1;
			int resultJ = J[c][d], resultO = O[c][d], resultI = I[c][d];
			if (a > 0) {
				resultJ -= J[a - 1][d];
				resultO -= O[a - 1][d];
				resultI -= I[a - 1][d];
				if (b > 0) {
					resultJ += J[a - 1][b - 1];
					resultO += O[a - 1][b - 1];
					resultI += I[a - 1][b - 1];
				}
			}
			if (b > 0) {
				resultJ -= J[c][b - 1];
				resultO -= O[c][b - 1];
				resultI -= I[c][b - 1];
			}
			System.out.println(resultJ + " " + resultO + " " + resultI);
		}
		sc.close();
	}
}