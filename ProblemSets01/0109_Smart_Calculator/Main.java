// Smart Calculator
import java.util.*;

public class Main {
	static int pos;
	static String formura;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			formura = scanner.next();
			pos = 0;
			int result = expression();
			System.out.println(result);
		}
		scanner.close();
	}

	static int expression() {
		int result = 0;
		int a = term();
		result += a;
		while (pos < formura.length()
				&& (formura.charAt(pos) == '+' || formura.charAt(pos) == '-')) {
			char op = formura.charAt(pos);
			pos++;
			int b = term();
			if (op == '+')
				result += b;
			else
				result -= b;
		}
		return result;
	}

	static int term() {
		int result = 0;
		int a = factor();
		result += a;
		while (pos < formura.length()
				&& (formura.charAt(pos) == '*' || formura.charAt(pos) == '/')) {
			char op = formura.charAt(pos);
			pos++;
			int b = factor();
			if (op == '*')
				result *= b;
			else
				result /= b;
		}
		return result;
	}

	static int factor() {
		int result = 0;
		if (formura.charAt(pos) == '(') {
			pos++;
			result = expression();
			pos++;
		} else {
			while (pos < formura.length()
					&& Character.isDigit(formura.charAt(pos))) {
				result *= 10;
				result += Character.getNumericValue(formura.charAt(pos));
				pos++;
			}
		}
		return result;
	}
}