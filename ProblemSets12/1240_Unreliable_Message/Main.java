import java.util.*;

public class Unreliable_Message {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int z = 0; z < n; z++) {
			String m = sc.next();
			String str = sc.next();
			for (int i = m.length() - 1; i >= 0; i--) {
				switch (m.charAt(i)) {
				case 'J':
					String f = str.substring(0, str.length() - 1);
					String e = str.substring(str.length() - 1);
					str = e + f;
					break;
				case 'C':
					f = str.substring(0, 1);
					e = str.substring(1);
					str = e + f;
					break;
				case 'E':
					if (str.length() % 2 == 0) {
						f = str.substring(0, str.length() / 2);
						e = str.substring(str.length() / 2);
						str = e + f;
					} else {
						f = str.substring(0, str.length() / 2);
						String c = str.substring(str.length() / 2,
								str.length() / 2 + 1);
						e = str.substring(str.length() / 2 + 1);
						str = e + c + f;
					}
					break;
				case 'A':
					char[] a = str.toCharArray();
					char[] b = new char[str.length()];
					for (int j = 0; j < str.length(); j++)
						b[str.length() - 1 - j] = a[j];
					str = String.valueOf(b);
					break;
				case 'P':
					a = str.toCharArray();
					for (int j = 0; j < str.length(); j++) {
						switch (a[j]) {
						case '0':
							a[j] = '9';
							break;
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
						case '9':
							a[j]--;
							break;
						}
					}
					str = String.valueOf(a);
					break;
				case 'M':
					a = str.toCharArray();
					for (int j = 0; j < str.length(); j++) {
						switch (a[j]) {
						case '0':
						case '1':
						case '2':
						case '3':
						case '4':
						case '5':
						case '6':
						case '7':
						case '8':
							a[j]++;
							break;
						case '9':
							a[j] = '0';
							break;
						}
					}
					str = String.valueOf(a);
					break;
				}
			}
			System.out.println(str);
		}
		sc.close();
	}
}
