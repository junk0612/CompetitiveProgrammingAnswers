// How can I satisfy thee? Let me count the ways...
import java.util.*;

public class Main {
	static int pos, p, q, r;
	static String formura;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			formura = scanner.next();
			if (formura.equals(".")) {
				break;
			}
			int result = 0;
			for (p = 0; p < 3; p++)
				for (q = 0; q < 3; q++)
					for (r = 0; r < 3; r++) {
						pos = 0;
						if (eval() == 2) {
							result++;
						}
					}
			System.out.println(result);
		}
		scanner.close();
	}

	public static int eval() {
		char c = formura.charAt(pos);
		pos++;
		if (c == '0')
			return 0;
		if (c == '1')
			return 1;
		if (c == '2')
			return 2;
		if (c == 'P')
			return p;
		if (c == 'Q')
			return q;
		if (c == 'R')
			return r;
		if (c == '-') {
			int result = eval();
			return 2 - result;
		}
		if (c == '(') {
			int a = eval();
			char op = formura.charAt(pos);
			pos++;
			int b = eval();
			pos++;
			if (op == '*')
				return Math.min(a, b);
			if (op == '+')
				return Math.max(a, b);
		}
		return -1;
	}
}