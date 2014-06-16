// Lost Number
import java.util.*;

public class Main {
	static String formula;
	static int pos;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		formula = sc.next();
		int result = replaceAndSearch();
		System.out.println(result);
		sc.close();
	}

	static int replaceAndSearch() {
		String[] replaces = { "0", "1", "+", "-", "*", "(", ")" };
		StringBuilder sb = new StringBuilder(formula);
		int result = -1;
		if (formula.contains(".")) {
			int p = formula.indexOf(".");
			for (int i = 0; i < replaces.length; i++) {
				formula = sb.replace(p, p + 1, replaces[i]).toString();
				result = Math.max(result, replaceAndSearch());
				formula = sb.replace(p, p + 1, ".").toString();
			}
		} else {
			pos = 0;
			if (isExp()) {
				result = exp();
			}
		}
		return result;
	}

	static boolean isExp() {
		if (!isTerm())
			return false;
		while (pos < formula.length()) {
			char op = formula.charAt(pos++);
			if (op != '+' && op != '-' && op != '*')
				return false;
			if (!isTerm())
				return false;
		}
		pos = 0;
		return true;
	}

	static boolean isTerm() {
		if (pos >= formula.length())
			return false;
		char c = formula.charAt(pos);
		if (c == '(') {
			pos++;
			return isParExp();
		}
		if (Character.isDigit(c)) {
			return isNumber();
		}
		return false;
	}

	static boolean isParExp() {
		if (!isTerm())
			return false;
		if (pos >= formula.length())
			return false;
		char op = formula.charAt(pos++);
		if (op != '+' && op != '-' && op != '*')
			return false;
		if (!isTerm())
			return false;
		while (pos < formula.length() && formula.charAt(pos) != ')') {
			op = formula.charAt(pos++);
			if (op != '+' && op != '-' && op != '*')
				return false;
			if (!isTerm())
				return false;
		}
		if (pos >= formula.length() || formula.charAt(pos++) != ')')
			return false;
		return true;
	}

	static boolean isNumber() {
		int result = 0;
		while (pos < formula.length() && Character.isDigit(formula.charAt(pos))) {
			result *= 2;
			result += formula.charAt(pos++) - '0';
		}
		return result >= 0 && result < 1024;
	}

	static int exp() {
		int result = term();
		if (result < 0 || result >= 1024)
			return -1;
		while (pos < formula.length() && formula.charAt(pos) != ')') {
			char op = formula.charAt(pos++);
			if (op == '+') {
				int t = term();
				if (t < 0 || t >= 1024)
					return -1;
				result += t;
			} else {
				int t = term();
				if (t < 0 || t >= 1024)
					return -1;
				result -= t;
			}
			if (result < 0 || result >= 1024)
				return -1;
		}
		pos++;
		return result;
	}

	static int term() {
		int result = mul();
		if (result < 0 || result >= 1024)
			return -1;
		while (pos < formula.length() && formula.charAt(pos) == '*') {
			pos++;
			int t = mul();
			if (t < 0 || t >= 1024)
				return -1;
			result *= t;
			if (result < 0 || result >= 1024)
				return -1;
		}
		return result;
	}

	static int mul() {
		if (formula.charAt(pos) == '(') {
			pos++;
			return exp();
		}
		int n = number();
		if (n < 0 || n >= 1024)
			return -1;
		return n;
	}

	static int number() {
		int result = 0;
		while (pos < formula.length() && Character.isDigit(formula.charAt(pos))) {
			result *= 2;
			result += formula.charAt(pos++) - '0';
		}
		return result;
	}

}
