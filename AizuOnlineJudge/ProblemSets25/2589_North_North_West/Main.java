import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
	static String input;
	static int pos;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			input = sc.next();
			if (input.equals("#"))
				break;
			pos = 0;
			int n = 0;
			List<String> dirList = new ArrayList<String>();
			List<Rational> list = new ArrayList<Rational>();
			while (pos < input.length()) {
				if (input.charAt(pos) == 'n') {
					dirList.add("north");
					pos += 5;
				} else {
					dirList.add("west");
					pos += 4;
				}
				n++;
			}
			Collections.reverse(dirList);
			for (int i = 0; i < n; i++) {
				String dir = dirList.get(i);
				if (dir.equals("north"))
					list.add(new Rational(-90, (long) Math.pow(2, i)));
				else
					list.add(new Rational(90, (long) Math.pow(2, i)));
			}
			Rational result = new Rational(0, 1);
			for (Rational rat : list) {
				result.add(rat);
			}
			System.out.println(result);
		}
		sc.close();
	}

	static class Rational {
		long child, base;

		Rational(long c, long b) {
			child = c;
			base = b;
		}

		public String toString() {
			if (base == 1)
				return Long.toString(child);
			return child + "/" + base;
		}

		public void add(Rational anotherRational) {
			long r = anotherRational.base / base;
			child *= r;
			base *= r;
			child += anotherRational.child;
			child = Math.max(child, 0);
			child = Math.min(child, base * 90);
			while (child % 2 == 0 && base % 2 == 0) {
				child /= 2;
				base /= 2;
			}
		}
	}
}
