// The Genome Database of All Space Life
import java.util.*;

public class Main {
	static String formula;
	static int pos;
	static int n;
	static StringBuilder sb;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			formula = sc.next();
			n = sc.nextInt();
			if (formula.equals("0") && n == 0)
				break;
			pos = 0;
			sb = new StringBuilder();
			parse();
			if (n >= sb.length())
				System.out.println(0);
			else
				System.out.println(sb.charAt(n));
		}
		sc.close();
	}

	static void parse() {
		while (pos < formula.length() && sb.length() <= n + 1)
			term();
	}

	static void term() {
		if (sb.length() > n + 1) {
			pos = formula.length();
			return;
		}
		if (Character.isUpperCase(formula.charAt(pos))) {
			if (sb.length() <= n + 1)
				sb.append(formula.charAt(pos));
			pos++;
			return;
		}
		int n = number();
		if (formula.charAt(pos) != '(') {
			for (int i = 0; i < n; i++)
				sb.append(formula.charAt(pos));
			pos++;
			return;
		}
		pos++;
		for (int i = 0; i < n - 1; i++) {
			int t = pos;
			while (pos < formula.length() && formula.charAt(pos) != ')')
				term();
			pos = t;
		}
		while (pos < formula.length() && formula.charAt(pos) != ')')
			term();
		pos++;
		return;
	}

	static int number() {
		int result = 0;
		while (Character.isDigit(formula.charAt(pos))) {
			result *= 10;
			result += formula.charAt(pos++) - '0';
		}
		return result;
	}
}
