// Miscalculation
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		String exp = sc.next();
		int res = sc.nextInt();
		boolean m = multiple(exp, res);
		boolean l = left(exp, res);
		if (m && l)
			System.out.println('U');
		else if (m)
			System.out.println('M');
		else if (l)
			System.out.println('L');
		else
			System.out.println('I');
		sc.close();
	}

	private boolean left(String exp, int res) {
		int result = 0;
		char op = '+';
		for (char c : exp.toCharArray()) {
			if (Character.isDigit(c))
				if (op == '+')
					result += c - '0';
				else
					result *= c - '0';
			else
				op = c;
		}
		return result == res;
	}

	private boolean multiple(String exp, int res) {
		String[] terms = exp.split("\\+");
		int sum = 0;
		for (String term : terms) {
			String[] factors = term.split("\\*");
			int fact = 1;
			for (String factor : factors) {
				fact *= Integer.parseInt(factor);
			}
			sum += fact;
		}
		return res == sum;
	}
}
