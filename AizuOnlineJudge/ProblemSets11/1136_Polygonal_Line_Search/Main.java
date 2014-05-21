import java.util.*;

public class Polygonal_Line_Search {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			Line[] lines = new Line[n + 1];
			for (int i = 0; i < n + 1; i++) {
				int m = sc.nextInt();
				lines[i] = new Line(i, m);
				for (int j = 0; j < m; j++) {
					lines[i].x[j] = sc.nextInt();
					lines[i].y[j] = sc.nextInt();
				}
				if (i == 0)
					lines[0].moveCenter();
				else
					lines[i].checkline(lines[0]);
			}
			System.out.println("+++++");
		}
		sc.close();
	}
}

class Line {
	int id;
	int m;
	int[] x;
	int[] y;

	Line(int i, int m) {
		id = i;
		this.m = m;
		x = new int[m];
		y = new int[m];
	}

	void checkline(Line anotherline) {
		moveCenter();
		for (int i = 0; i < 4; i++) {
			turn();
			if (check(anotherline)) {
				System.out.println(id);
				return;
			}
		}
		reverse();
		moveCenter();
		for (int i = 0; i < 4; i++) {
			turn();
			if (check(anotherline)) {
				System.out.println(id);
				return;
			}
		}
	}

	void reverse() {
		int[] tx = new int[m];
		int[] ty = new int[m];
		for (int i = 0; i < m; i++) {
			tx[i] = x[i];
			ty[i] = y[i];
		}
		for (int i = 0; i < m; i++) {
			x[i] = tx[m - 1 - i];
			y[i] = ty[m - 1 - i];
		}
	}

	void turn() {
		for (int i = 0; i < m; i++) {
			int t = x[i];
			x[i] = -y[i];
			y[i] = t;
		}
	}

	void moveCenter() {
		for (int i = 0; i < m; i++) {
			x[i] -= x[m - 1];
			y[i] -= y[m - 1];
		}
	}

	boolean check(Line anotherline) {
		boolean b = this.m == anotherline.m;
		if (b)
			for (int i = 0; i < this.m; i++)
				b = b && (this.x[i] == anotherline.x[i])
						&& (this.y[i] == anotherline.y[i]);
		return b;
	}
}