// Bug Hunt
import java.util.*;

public class Main {
	static String statement;
	static int pos;
	static Map<Character, Integer> sizes;
	static Map<Data, Integer> values;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		out: while (true) {
			int result = 0;
			int counter = 1;
			sizes = new HashMap<Character, Integer>();
			values = new HashMap<Data, Integer>();
			while (true) {
				statement = sc.next();
				pos = 0;
				if (statement.equals(".")) {
					if (counter != 1)
						break;
					break out;
				}
				if (!statement.contains("="))
					declaration();
				else if (!assignment()) {
					result = counter;
					break;
				}
				counter++;
			}
			System.out.println(result);
			while (!statement.equals("."))
				statement = sc.next();
		}
		sc.close();
	}

	static void declaration() {
		char array = statement.charAt(pos++);
		pos++;
		int num = number();
		sizes.put(array, num);
	}

	static boolean assignment() {
		char array = statement.charAt(pos++);
		if (!sizes.containsKey(array))
			return false;
		pos++;
		int n = -1;
		if (Character.isDigit(statement.charAt(pos)))
			n = number();
		else
			n = expression();
		if (n == -1 || n >= sizes.get(array))
			return false;
		pos++;
		Data data = new Data(array, n);
		pos++;
		int r = expression();
		if (r == -1)
			return false;
		values.put(data, r);
		return true;
	}

	static int number() {
		int result = 0;
		while (pos < statement.length()
				&& Character.isDigit(statement.charAt(pos))) {
			result *= 10;
			result += statement.charAt(pos++) - '0';
		}
		return result;
	}

	static int expression() {
		if (Character.isDigit(statement.charAt(pos)))
			return number();
		char name = statement.charAt(pos++);
		pos++;
		int n = -1;
		if (Character.isDigit(statement.charAt(pos)))
			n = number();
		else
			n = expression();
		if (n == -1)
			return -1;
		Data data = new Data(name, n);
		pos++;
		if (values.containsKey(data))
			return values.get(data);
		return -1;
	}

	static class Data {
		char name;
		int num;

		Data(char na, int nu) {
			name = na;
			num = nu;
		}

		@Override
		public boolean equals(Object anotherData) {
			return this.name == ((Data) anotherData).name
					&& this.num == ((Data) anotherData).num;
		}

		@Override
		public int hashCode() {
			return new Character(name).hashCode() + new Integer(num).hashCode();
		}
	}
}
