// Chain Disappearance Puzzle
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[][] field;
	static int h;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			h = sc.nextInt();
			if (h == 0)
				break;
			field = new int[h][5];
			for (int i = 0; i < h; i++)
				for (int j = 0; j < 5; j++)
					field[i][j] = sc.nextInt();
			System.out.println(disappear());
		}
		sc.close();
	}

	static int disappear() {
		int result = 0;
		boolean[][] bfield = new boolean[h][5];
		boolean canDelete = true;
		while (canDelete) {
			canDelete = false;
			for (int i = 0; i < h; i++) {
				Arrays.fill(bfield[i], false);
				for (int j = 0; j < 3; j++) {
					if (field[i][j] != 0 && field[i][j] == field[i][j + 1]
							&& field[i][j] == field[i][j + 2]) {
						bfield[i][j] = true;
						bfield[i][j + 1] = true;
						bfield[i][j + 2] = true;
						canDelete = true;
					}
				}
				for (int j = 0; j < 5; j++)
					if (bfield[i][j]) {
						result += field[i][j];
						field[i][j] = 0;
					}
			}
			for (int i = 0; i < 5; i++) {
				for (int t = h; t > 0; t--) {
					for (int j = 1; j < t; j++) {
						if (field[j][i] == 0) {
							int temp = field[j][i];
							field[j][i] = field[j - 1][i];
							field[j - 1][i] = temp;
						}
					}
					if (field[t - 1][i] == 0)
						break;
				}
			}
		}
		return result;
	}
}
