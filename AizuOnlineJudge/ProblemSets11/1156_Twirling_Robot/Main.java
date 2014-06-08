// Twirling Robot
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { -1, 0, 1, 0 };
		while (true) {
			int w = sc.nextInt(), h = sc.nextInt();
			if ((w | h) == 0)
				break;
			int[][] field = new int[h][w];
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++)
					field[i][j] = sc.nextInt();
			int[] command = new int[4];
			for (int i = 0; i < 4; i++)
				command[i] = sc.nextInt();
			int[][][] costs = new int[4][h][w];
			for (int k = 0; k < 4; k++)
				for (int i = 0; i < h; i++)
					Arrays.fill(costs[k][i], -1);
			PriorityQueue<Node> queue = new PriorityQueue<Node>();
			queue.add(new Node(0, 0, 0, 'E'));
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				int x = node.x;
				int y = node.y;
				int cost = node.cost;
				if (node.dir == 'N') {
					if (costs[0][y][x] >= 0 && costs[0][y][x] <= cost)
						continue;
					costs[0][y][x] = cost;
					for (int i = 0; i < 4; i++) {
						int tcost = cost;
						if (field[y][x] != i)
							tcost += command[i];
						int tx = x + dx[i];
						int ty = y + dy[i];
						if (tx >= 0 && tx < w && ty >= 0 && ty < h)
							switch (i) {
							case 0:
								queue.add(new Node(tx, ty, tcost, 'N'));
								break;
							case 1:
								queue.add(new Node(tx, ty, tcost, 'E'));
								break;
							case 2:
								queue.add(new Node(tx, ty, tcost, 'S'));
								break;
							default:
								queue.add(new Node(tx, ty, tcost, 'W'));
							}
					}
				}
				if (node.dir == 'E') {
					if (costs[1][y][x] >= 0 && costs[1][y][x] <= cost)
						continue;
					costs[1][y][x] = cost;
					for (int i = 0; i < 4; i++) {
						int tcost = cost;
						if (field[y][x] != i)
							tcost += command[i];
						int tx = x + dx[(1 + i) % 4];
						int ty = y + dy[(1 + i) % 4];
						if (tx >= 0 && tx < w && ty >= 0 && ty < h)
							switch (i) {
							case 0:
								queue.add(new Node(tx, ty, tcost, 'E'));
								break;
							case 1:
								queue.add(new Node(tx, ty, tcost, 'S'));
								break;
							case 2:
								queue.add(new Node(tx, ty, tcost, 'W'));
								break;
							default:
								queue.add(new Node(tx, ty, tcost, 'N'));
							}
					}
				}
				if (node.dir == 'S') {
					if (costs[2][y][x] >= 0 && costs[2][y][x] <= cost)
						continue;
					costs[2][y][x] = cost;
					for (int i = 0; i < 4; i++) {
						int tcost = cost;
						if (field[y][x] != i)
							tcost += command[i];
						int tx = x + dx[(2 + i) % 4];
						int ty = y + dy[(2 + i) % 4];
						if (tx >= 0 && tx < w && ty >= 0 && ty < h)
							switch (i) {
							case 0:
								queue.add(new Node(tx, ty, tcost, 'S'));
								break;
							case 1:
								queue.add(new Node(tx, ty, tcost, 'W'));
								break;
							case 2:
								queue.add(new Node(tx, ty, tcost, 'N'));
								break;
							default:
								queue.add(new Node(tx, ty, tcost, 'E'));
							}
					}
				}
				if (node.dir == 'W') {
					if (costs[3][y][x] >= 0 && costs[3][y][x] <= cost)
						continue;
					costs[3][y][x] = cost;
					for (int i = 0; i < 4; i++) {
						int tcost = cost;
						if (field[y][x] != i)
							tcost += command[i];
						int tx = x + dx[(3 + i) % 4];
						int ty = y + dy[(3 + i) % 4];
						if (tx >= 0 && tx < w && ty >= 0 && ty < h)
							switch (i) {
							case 0:
								queue.add(new Node(tx, ty, tcost, 'W'));
								break;
							case 1:
								queue.add(new Node(tx, ty, tcost, 'N'));
								break;
							case 2:
								queue.add(new Node(tx, ty, tcost, 'E'));
								break;
							default:
								queue.add(new Node(tx, ty, tcost, 'S'));
							}
					}
				}
			}
			int result = Integer.MAX_VALUE;
			for (int i = 0; i < 4; i++)
				if (costs[i][h - 1][w - 1] >= 0)
					result = Math.min(result, costs[i][h - 1][w - 1]);
			System.out.println(result);
		}
		sc.close();
	}

	static class Node implements Comparable<Node> {
		int x, y, cost;
		char dir;

		Node(int i, int j, int c, char d) {
			x = i;
			y = j;
			cost = c;
			dir = d;
		}

		public int compareTo(Node anotherNode) {
			if (this.dir == anotherNode.dir)
				return this.cost - anotherNode.cost;
			return this.dir - anotherNode.dir;
		}

	}
}
