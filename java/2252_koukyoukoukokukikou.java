import java.util.*;

public class koukyoukoukokukikou {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String s = sc.next();
			if (s.equals("#"))
				break;
			char[] c = new char[s.length()];
			for (int i = 0; i < s.length(); i++) {
				switch (s.charAt(i)) {
				case 'a':
				case 'b':
				case 'c':
				case 'd':
				case 'e':
				case 'f':
				case 'g':
				case 'q':
				case 'r':
				case 's':
				case 't':
				case 'v':
				case 'w':
				case 'x':
				case 'z':
					c[i] = 'l';
					break;
				case 'h':
				case 'i':
				case 'j':
				case 'k':
				case 'l':
				case 'm':
				case 'n':
				case 'o':
				case 'p':
				case 'u':
				case 'y':
					c[i] = 'r';
					break;
				default:
					c[i] = ' ';
					break;
				}
			}
			char nc = c[0];
			int result = 0;
			for (int i = 0; i < s.length(); i++) {
				if (nc != c[i]) {
					result++;
					nc = c[i];
				}
			}
			System.out.println(result);
		}
		sc.close();
	}
}
