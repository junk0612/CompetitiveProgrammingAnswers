import java.util.*;

public class Amazing_Mazes {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			int[][] var = new int[w - 1][h];
			int[][] hor = new int[w][h - 1];
			for (int i = 0; i < h - 1; i++) {
				for (int j = 0; j < w - 1; j++)
					var[j][i] = sc.nextInt();
				for (int j = 0; j < w; j++)
					hor[j][i] = sc.nextInt();
			}
			for (int i = 0; i < w - 1; i++)
				var[i][h - 1] = sc.nextInt();
			int[][] field = new int[w][h];
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++)
					field[j][i] = 0;
			field[0][0] = 1;
			for (int f = 1; true; f++) {
				for (int i = 0; i < h; i++)
					for (int j = 0; j < w; j++) {
						if (field[j][i] == f) {
							if (j > 0 && var[j - 1][i] == 0) {
								if (field[j - 1][i] > 0)
									field[j - 1][i] = Math.min(field[j - 1][i],
											field[j][i] + 1);
								else
									field[j - 1][i] = field[j][i] + 1;
							}
							if (i > 0 && hor[j][i - 1] == 0) {
								if (field[j][i - 1] > 0)
									field[j][i - 1] = Math.min(field[j][i - 1],
											field[j][i] + 1);
								else
									field[j][i - 1] = field[j][i] + 1;
							}
							if (j < w - 1 && var[j][i] == 0) {
								if (field[j + 1][i] > 0)
									field[j + 1][i] = Math.min(field[j + 1][i],
											field[j][i] + 1);
								else
									field[j + 1][i] = field[j][i] + 1;
							}
							if (i < h - 1 && hor[j][i] == 0) {
								if (field[j][i + 1] > 0)
									field[j][i + 1] = Math.min(field[j][i + 1],
											field[j][i] + 1);
								else
									field[j][i + 1] = field[j][i] + 1;
							}
						}
					}
				if (field[w - 1][h - 1] > 0)
					break;
				if (f > w * h + 1)
					break;
			}
			System.out.println(field[w - 1][h - 1]);
		}
		sc.close();
	}
}
