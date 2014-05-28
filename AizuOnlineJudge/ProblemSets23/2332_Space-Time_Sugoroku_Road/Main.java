// Space-Time Sugoroku Road
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] road = new int[N];
		boolean[] selected = new boolean[N];
		Arrays.fill(selected, false);
		for (int i = 0; i < N; i++)
			road[i] = sc.nextInt();
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		Node n = new Node(0, 0);
		queue.add(n);
		while (!queue.isEmpty()) {
			n = queue.poll();
			if (n.num == N - 1)
				break;
			if (!selected[n.num]) {
				if (road[n.num] != 0)
					queue.add(new Node(n.num + road[n.num], n.cost));
				else
					for (int i = 1; i <= 6; i++)
						queue.add(new Node(n.num + i, n.cost + 1));
				selected[n.num] = true;
			}
		}
		System.out.println(n.cost);
		sc.close();
	}

	static class Node implements Comparable<Node> {
		int num, cost;

		Node(int n, int c) {
			num = n;
			cost = c;
		}

		@Override
		public int compareTo(Node anotherNode) {
			if (this.cost == anotherNode.cost)
				return this.num - anotherNode.num;
			return this.cost - anotherNode.cost;
		}

	}
}