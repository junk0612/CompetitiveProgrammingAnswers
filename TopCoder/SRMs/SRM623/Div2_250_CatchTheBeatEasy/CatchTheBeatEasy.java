import java.util.*;

public class CatchTheBeatEasy {

	public String ableToCatchAll(int[] x, int[] y) {
		PriorityQueue<Node> queue = new PriorityQueue<Node>();
		queue.add(new Node(0, 0));
		for (int i = 0; i < x.length; i++)
			queue.add(new Node(x[i], y[i]));
		boolean b = true;
		Node node = queue.poll();
		while (!queue.isEmpty() && b) {
			Node newnode = queue.poll();
			b = b && (Math.abs(newnode.x - node.x) <= newnode.y - node.y);
			node = newnode;
		}
		if (b)
			return "Able to catch";
		return "Not able to catch";
	}

	class Node implements Comparable<Node> {
		int x, y;

		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(Node o) {
			return this.y - o.y;
		}
	}

}
