// Cliff Climbing
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int w = sc.nextInt(), h = sc.nextInt();
			if ((w | h) == 0)
				break;
			int[][] cliff = new int[h][w];
			int[][][] costs = new int[2][h][w];
			for (int i = 0; i < h; i++) {
				Arrays.fill(cliff[i], -1);
				Arrays.fill(costs[0][i], -1);
				Arrays.fill(costs[1][i], -1);
			}
			List<Integer> gx = new ArrayList<Integer>();
			List<Integer> gy = new ArrayList<Integer>();
			PriorityQueue<Node> queue = new PriorityQueue<Node>();
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++) {
					char c = sc.next().charAt(0);
					if (Character.isDigit(c))
						cliff[i][j] = c - '0';
					else if (c == 'S') {
						cliff[i][j] = 0;
						queue.add(new Node(j, i, 0, 'R'));
						queue.add(new Node(j, i, 0, 'L'));
					} else if (c == 'T') {
						cliff[i][j] = 0;
						gx.add(j);
						gy.add(i);
					} else if (c == 'X')
						cliff[i][j] = -1;
				}
			while (!queue.isEmpty()) {
				Node node = queue.poll();
				int tx = node.x;
				int ty = node.y;
				int tc = node.cost;
				char tf = node.foot;
				if (tf == 'R') {
					if (costs[0][ty][tx] >= 0 && costs[0][ty][tx] <= tc)
						continue;
					costs[0][ty][tx] = tc;
					for (int lx = -3; lx <= -1; lx++)
						for (int ly = -3 - lx; ly <= 3 + lx; ly++) {
							int x = tx + lx;
							int y = ty + ly;
							if (x >= 0 && x < w && y >= 0 && y < h
									&& cliff[y][x] >= 0)
								queue.add(new Node(x, y, tc + cliff[y][x], 'L'));
						}
				} else {
					if (costs[1][ty][tx] >= 0 && costs[1][ty][tx] <= tc)
						continue;
					costs[1][ty][tx] = tc;
					for (int rx = 1; rx <= 3; rx++)
						for (int ry = -3 + rx; ry <= 3 - rx; ry++) {
							int x = tx + rx;
							int y = ty + ry;
							if (x >= 0 && x < w && y >= 0 && y < h
									&& cliff[y][x] >= 0)
								queue.add(new Node(x, y, tc + cliff[y][x], 'R'));
						}
				}
			}
			int result = -1;
			for (int i : gy)
				for (int j : gx)
					for (int k = 0; k < 2; k++) {
						if (result == -1)
							result = costs[k][i][j];
						else if (costs[k][i][j] >= 0)
							result = Math.min(result, costs[k][i][j]);
					}
			System.out.println(result);
		}
		sc.close();
	}

	static class Node implements Comparable<Node> {
		int x, y, cost;
		char foot;

		Node(int i, int j, int c, char f) {
			x = i;
			y = j;
			cost = c;
			foot = f;
		}

		public int compareTo(Node anotherNode) {
			if (this.foot == anotherNode.foot)
				return this.cost - anotherNode.cost;
			return this.foot - anotherNode.foot;
		}

	}
}
