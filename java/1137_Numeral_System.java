import java.util.*;

public class Numeral_System {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String astr = sc.next();
			String bstr = sc.next();
			int a = 0, b = 0;
			int l = 1;
			for (int j = 0; j < astr.length(); j++) {
				switch (astr.charAt(j)) {
				case '2':
					l = 2;
					break;
				case '3':
					l = 3;
					break;
				case '4':
					l = 4;
					break;
				case '5':
					l = 5;
					break;
				case '6':
					l = 6;
					break;
				case '7':
					l = 7;
					break;
				case '8':
					l = 8;
					break;
				case '9':
					l = 9;
					break;
				case 'm':
					a += l * 1000;
					l = 1;
					break;
				case 'c':
					a += l * 100;
					l = 1;
					break;
				case 'x':
					a += l * 10;
					l = 1;
					break;
				case 'i':
					a += l;
					l = 1;
					break;
				default:
					break;
				}
			}
			l = 1;
			for (int j = 0; j < bstr.length(); j++) {
				switch (bstr.charAt(j)) {
				case '2':
					l = 2;
					break;
				case '3':
					l = 3;
					break;
				case '4':
					l = 4;
					break;
				case '5':
					l = 5;
					break;
				case '6':
					l = 6;
					break;
				case '7':
					l = 7;
					break;
				case '8':
					l = 8;
					break;
				case '9':
					l = 9;
					break;
				case 'm':
					b += l * 1000;
					l = 1;
					break;
				case 'c':
					b += l * 100;
					l = 1;
					break;
				case 'x':
					b += l * 10;
					l = 1;
					break;
				case 'i':
					b += l;
					l = 1;
					break;
				default:
					break;
				}
			}
			int c = a + b;
			String cr = Integer.toString(c);
			String cstr = "";
			for (int j = 0; j < cr.length(); j++) {
				switch (cr.charAt(j)) {
				case '0':
					cstr += "";
					break;
				case '1':
					cstr += "";
					break;
				case '2':
					cstr += "2";
					break;
				case '3':
					cstr += "3";
					break;
				case '4':
					cstr += "4";
					break;
				case '5':
					cstr += "5";
					break;
				case '6':
					cstr += "6";
					break;
				case '7':
					cstr += "7";
					break;
				case '8':
					cstr += "8";
					break;
				case '9':
					cstr += "9";
					break;
				}
				switch (cr.length()) {
				case 1:
					if (cr.charAt(j) != '0')
						cstr += "i";
					break;
				case 2:
					if (cr.charAt(j) != '0')
						switch (j) {
						case 0:
							cstr += "x";
							break;
						case 1:
							cstr += "i";
							break;
						}
					break;
				case 3:
					if (cr.charAt(j) != '0')
						switch (j) {
						case 0:
							cstr += "c";
							break;
						case 1:
							cstr += "x";
							break;
						case 2:
							cstr += "i";
							break;
						}
					break;
				case 4:
					if (cr.charAt(j) != '0')
						switch (j) {
						case 0:
							cstr += "m";
							break;
						case 1:
							cstr += "c";
							break;
						case 2:
							cstr += "x";
							break;
						case 3:
							cstr += "i";
							break;
						}
					break;
				}
			}
			System.out.println(cstr);
		}
		sc.close();
	}
}