import java.util.*;

public class Get_Many_Persimmon_Trees {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int w = sc.nextInt();
			int h = sc.nextInt();
			int[][] field = new int[w][h];
			for (int i = 0; i < w; i++)
				for (int j = 0; j < h; j++)
					field[i][j] = 0;
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				field[x - 1][y - 1] = 1;
			}
			int s = sc.nextInt();
			int t = sc.nextInt();
			for (int i = 0; i <= w - s; i++)
				for (int j = 0; j <= h - t; j++)
					for (int k = i; k < i + s; k++)
						for (int l = j; l < j + t; l++)
							if (i != k || j != l)
								field[i][j] += field[k][l];
			int max = 0;
			for (int i = 0; i < w; i++)
				for (int j = 0; j < h; j++)
					max = Math.max(max, field[i][j]);
			System.out.println(max);
		}
		sc.close();
	}
}