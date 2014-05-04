// Identically Colored Panels Connection
import java.util.*;

public class Main {
	static int w, h;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			h = scanner.nextInt();
			w = scanner.nextInt();
			int c = scanner.nextInt();
			if ((h | w | c) == 0)
				break;
			int[][] field = new int[w][h];
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++)
					field[j][i] = scanner.nextInt();
			int result = 0;
			for (int i = 1; i < 7; i++) {
				if (i != field[0][0]) {
					int[][] tfield1 = changeField(field, i);
					for (int j = 1; j < 7; j++) {
						if (j != tfield1[0][0]) {
							int[][] tfield2 = changeField(tfield1, j);
							for (int k = 1; k < 7; k++)
								if (k != tfield2[0][0]) {
									int[][] tfield3 = changeField(tfield2, k);
									for (int l = 1; l < 7; l++) {
										if (l != tfield3[0][0]) {
											int[][] tfield4 = changeField(
													tfield3, l);
											if (l == c) {
												result = Math.max(result,
														count(tfield4, 0, 0));
											} else {
												int[][] tfield5 = changeField(
														tfield4, c);
												result = Math.max(result,
														count(tfield5, 0, 0));
											}
										}
									}
								}
						}
					}
					result = Math.max(result, count(tfield1, 0, 0));
				}
			}
			System.out.println(result);
		}
		scanner.close();
	}

	static int[][] changeField(int[][] field, int change) {
		int[][] result = new int[w][h];
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				result[j][i] = field[j][i];
		changeColor(result, change, 0, 0);
		return result;
	}

	static void changeColor(int[][] field, int change, int x, int y) {
		int b = field[x][y];
		field[x][y] = change;
		if (x > 0 && b == field[x - 1][y])
			changeColor(field, change, x - 1, y);
		if (x < w - 1 && b == field[x + 1][y])
			changeColor(field, change, x + 1, y);
		if (y > 0 && b == field[x][y - 1])
			changeColor(field, change, x, y - 1);
		if (y < h - 1 && b == field[x][y + 1])
			changeColor(field, change, x, y + 1);
	}

	static int count(int[][] field, int x, int y) {
		int result = 1;
		int b = field[x][y];
		field[x][y] = 0;
		if (x > 0 && b == field[x - 1][y])
			result += count(field, x - 1, y);
		if (x < w - 1 && b == field[x + 1][y])
			result += count(field, x + 1, y);
		if (y > 0 && b == field[x][y - 1])
			result += count(field, x, y - 1);
		if (y < h - 1 && b == field[x][y + 1])
			result += count(field, x, y + 1);
		return result;
	}
}