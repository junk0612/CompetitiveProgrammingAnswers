// Repeated Substitution with Sed
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int n = scanner.nextInt();
			if (n == 0)
				break;
			String[] alpha = new String[n];
			String[] beta = new String[n];
			for (int i = 0; i < n; i++) {
				alpha[i] = scanner.next();
				beta[i] = scanner.next();
			}
			String start = scanner.next();
			String goal = scanner.next();
			Queue<State> queue = new LinkedList<State>();
			queue.add(new State(0, start));
			int result = -1;
			while (!queue.isEmpty()) {
				State state = queue.poll();
				String str = state.str;
				if (str.equals(goal)) {
					result = state.num;
					break;
				}
				for (int i = 0; i < n; i++) {
					String t = str.replace(alpha[i], beta[i]);
					if (!str.equals(t) && t.length() <= goal.length()) {
						queue.add(new State(state.num + 1, t));
					}
				}
			}
			System.out.println(result);
		}
		scanner.close();
	}
}

class State {
	int num;
	String str;

	State(int n, String s) {
		num = n;
		str = s;
	}
}
