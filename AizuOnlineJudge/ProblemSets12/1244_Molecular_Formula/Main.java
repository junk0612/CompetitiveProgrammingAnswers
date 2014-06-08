// Molecular Formula
import java.util.*;

public class Main {
	static String formula;
	static int pos;
	static Map<String, Integer> table;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		table = new HashMap<String, Integer>();
		while (true) {
			String atom = sc.next();
			if (atom.equals("END_OF_FIRST_PART"))
				break;
			int weight = sc.nextInt();
			table.put(atom, weight);
		}
		while (true) {
			formula = sc.next();
			pos = 0;
			if (formula.equals("0"))
				break;
			int result = formula();
			if (result == -1)
				System.out.println("UNKNOWN");
			else
				System.out.println(result);
		}
		sc.close();
	}

	static int formula() {
		int result = 0;
		while (pos < formula.length()) {
			int t = molecule();
			if (t == -1)
				return -1;
			result += t;
		}
		return result;
	}

	static int molecule() {
		int result = 0;
		char c = formula.charAt(pos);
		if (c == '(') {
			pos++;
			while (formula.charAt(pos) != ')')
				result += molecule();
			pos++;
			result *= number();
		} else {
			result = atom();
			if (result == -1)
				return -1;
			if (pos < formula.length()
					&& Character.isDigit(formula.charAt(pos)))
				result *= number();
		}
		return result;
	}

	static int atom() {
		String atom = formula.substring(pos, ++pos);
		if (pos < formula.length()
				&& Character.isLowerCase(formula.charAt(pos)))
			atom += formula.charAt(pos++);
		if (table.containsKey(atom))
			return table.get(atom);
		return -1;
	}

	static int number() {
		int result = 0;
		while (pos < formula.length() && Character.isDigit(formula.charAt(pos))) {
			result *= 10;
			result += formula.charAt(pos++) - '0';
		}
		return result;
	}
}
