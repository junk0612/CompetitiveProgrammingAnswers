import java.util.Comparator;
import java.util.PriorityQueue;

public class HappyLetterDiv1 {

	public String getHappyLetters(String letters) {
		char[] lets = letters.toCharArray();
		int[] letCount = new int[26];
		for (char c : lets)
			letCount[c - 'a']++;
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < letCount.length; i++) {
			if (letCount[i] > 0) {
				PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
						new DescendingOrderComparator());
				for (int j = 0; j < letCount.length; j++)
					if (j != i && letCount[j] > 0)
						queue.add(letCount[j]);
				while (queue.size() > 1) {
					int a = queue.poll() - 1;
					int b = queue.poll() - 1;
					if (a > 0)
						queue.add(a);
					if (b > 0)
						queue.add(b);
				}
				if (queue.isEmpty() || queue.poll() < letCount[i])
					result.append((char) ('a' + i));
			}
		}
		return result.toString();
	}

	private class DescendingOrderComparator implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}

	}
}
