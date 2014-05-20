// CatChecker
import java.util.*;

public class Main {
	static String s;
	static int pos;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		pos = 0;
		s = scanner.next();
		if (cat() && pos == s.length())
			System.out.println("Cat");
		else
			System.out.println("Rabbit");
		scanner.close();
	}

	static boolean cat() {
		char m = s.charAt(pos);
		if (m == 'm') {
			pos++;
			char e = s.charAt(pos);
			if (e == 'e') {
				pos++;
				char w = s.charAt(pos);
				if (w == 'w') {
					pos++;
					return true;
				}
				boolean mew = cat();
				w = s.charAt(pos);
				if (mew && w == 'w') {
					pos++;
					return true;
				}
				return false;
			}
			boolean mewmew = cat();
			e = s.charAt(pos);
			if (mewmew && e == 'e') {
				pos++;
				char w = s.charAt(pos);
				if (w == 'w') {
					pos++;
					return true;
				}
				boolean mew = cat();
				w = s.charAt(pos);
				if (mew && w == 'w') {
					pos++;
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}
}
