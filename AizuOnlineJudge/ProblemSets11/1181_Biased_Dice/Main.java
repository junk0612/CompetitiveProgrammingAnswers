// Biased Dice
import java.util.*;

public class Main {
	static final int CENTER = 100;
	static int[][] heights;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			heights = new int[201][201];
			int[][] tops = new int[201][201];
			for (int i = 0; i < n; i++) {
				int t = sc.nextInt(), f = sc.nextInt();
				Dice dice = new Dice(t, f);
				while (dice.canRoll())
					dice.roll();
				tops[dice.x][dice.y] = dice.top;
			}
			int[] result = new int[6];
			for (int i = 0; i < 201; i++)
				for (int j = 0; j < 201; j++)
					if (tops[i][j] > 0)
						result[tops[i][j] - 1]++;
			for (int i = 0; i < 5; i++)
				System.out.print(result[i] + " ");
			System.out.println(result[5]);
		}
		sc.close();
	}

	static class Dice {
		int top, front, right;
		int x, y, height, dir;

		Dice(int t, int f) {
			top = t;
			front = f;
			x = CENTER;
			y = CENTER;
			height = heights[x][y] + 1;
			heights[x][y]++;
			switch (t) {
			case 1:
				switch (f) {
				case 2:
					right = 3;
					break;
				case 3:
					right = 5;
					break;
				case 4:
					right = 2;
					break;
				case 5:
					right = 4;
					break;
				}
				break;
			case 2:
				switch (f) {
				case 1:
					right = 4;
					break;
				case 3:
					right = 1;
					break;
				case 4:
					right = 6;
					break;
				case 6:
					right = 3;
					break;
				}
				break;
			case 3:
				switch (f) {
				case 1:
					right = 2;
					break;
				case 2:
					right = 6;
					break;
				case 5:
					right = 1;
					break;
				case 6:
					right = 5;
					break;
				}
				break;
			case 4:
				switch (f) {
				case 1:
					right = 5;
					break;
				case 2:
					right = 1;
					break;
				case 5:
					right = 6;
					break;
				case 6:
					right = 2;
					break;
				}
				break;
			case 5:
				switch (f) {
				case 1:
					right = 3;
					break;
				case 3:
					right = 6;
					break;
				case 4:
					right = 1;
					break;
				case 6:
					right = 4;
					break;
				}
				break;
			case 6:
				switch (f) {
				case 2:
					right = 4;
					break;
				case 3:
					right = 2;
					break;
				case 4:
					right = 5;
					break;
				case 5:
					right = 3;
					break;
				}
				break;
			}
		}

		void rollR() {
			x++;
			int t = 7 - right;
			right = top;
			top = t;
		}

		boolean canRoll() {
			int[] d = { front, 7 - front, right, 7 - right };
			int[] dx = { 0, 0, 1, -1 };
			int[] dy = { 1, -1, 0, 0 };
			for (int i = 6; i >= 4; i--) {
				for (int j = 0; j < 4; j++) {
					if (i == d[j]
							&& heights[x][y] - 1 > heights[x + dx[j]][y + dy[j]]) {
						dir = j;
						return true;
					}
				}
			}
			return false;
		}

		void roll() {
			heights[x][y]--;
			switch (dir) {
			case 0:
				rollF();
				break;
			case 1:
				rollB();
				break;
			case 2:
				rollR();
				break;
			case 3:
				rollL();
				break;
			}
			heights[x][y]++;
			height = heights[x][y];
		}

		void rollL() {
			x--;
			int t = 7 - top;
			top = right;
			right = t;
		}

		void rollF() {
			y++;
			int t = 7 - front;
			front = top;
			top = t;
		}

		void rollB() {
			y--;
			int t = 7 - top;
			top = front;
			front = t;
		}
	}
}
