// Red and Black
import java.util.Scanner;

public class Main {
	int w, h;
	String[] field;
	boolean[][] visited;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if ((w | h) == 0)
				break;
			field = new String[h];
			visited = new boolean[h][w];
			int result = 0;
			for (int i = 0; i < h; i++)
				field[i] = sc.next();
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (field[i].charAt(j) == '@') {
						result = visit(j, i);
						break;
					}
				}
			}
			System.out.println(result);
		}
		sc.close();
	}

	int visit(int x, int y) {
		int result = 1;
		visited[y][x] = true;
		if (x > 0 && field[y].charAt(x - 1) != '#' && !visited[y][x - 1])
			result += visit(x - 1, y);
		if (x < w - 1 && field[y].charAt(x + 1) != '#' && !visited[y][x + 1])
			result += visit(x + 1, y);
		if (y > 0 && field[y - 1].charAt(x) != '#' && !visited[y - 1][x])
			result += visit(x, y - 1);
		if (y < h - 1 && field[y + 1].charAt(x) != '#' && !visited[y + 1][x])
			result += visit(x, y + 1);
		return result;
	}
}
