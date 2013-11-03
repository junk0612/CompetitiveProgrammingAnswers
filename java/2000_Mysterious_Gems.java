import java.util.Scanner;

public class Mysterious_Gems {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int[][] field = new int[21][21];
			for (int i = 0; i < 21; i++)
				for (int j = 0; j < 21; j++)
					field[i][j] = 0;
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				field[x][y] = 1;
			}
			int m = sc.nextInt();
			int nx = 10;
			int ny = 10;
			for (int i = 0; i < m; i++) {
				String s = sc.next();
				int d = sc.nextInt();
				if (s.equals("N"))
					for (int j = 0; j < d; j++) {
						ny++;
						if (field[nx][ny] == 1) {
							field[nx][ny] = 0;
							n--;
						}
					}
				if (s.equals("S"))
					for (int j = 0; j < d; j++) {
						ny--;
						if (field[nx][ny] == 1) {
							field[nx][ny] = 0;
							n--;
						}
					}
				if (s.equals("E"))
					for (int j = 0; j < d; j++) {
						nx++;
						if (field[nx][ny] == 1) {
							field[nx][ny] = 0;
							n--;
						}
					}
				if (s.equals("W"))
					for (int j = 0; j < d; j++) {
						nx--;
						if (field[nx][ny] == 1) {
							field[nx][ny] = 0;
							n--;
						}
					}
			}
			if (n == 0)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
		sc.close();
	}
}
