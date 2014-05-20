// Equation
import java.util.*;

public class Main {
	static int pos;
	static String equation;
	static int a, b, c, d, e, f, g, h, i, j, k;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			equation = scanner.next();
			if (equation.equals("#"))
				break;
			boolean result = true;
			out: for (a = 0; a < 2; a++)
				for (b = 0; b < 2; b++)
					for (c = 0; c < 2; c++)
						for (d = 0; d < 2; d++)
							for (e = 0; e < 2; e++)
								for (f = 0; f < 2; f++)
									for (g = 0; g < 2; g++)
										for (h = 0; h < 2; h++)
											for (i = 0; i < 2; i++)
												for (j = 0; j < 2; j++)
													for (k = 0; k < 2; k++) {
														pos = 0;
														result = result
																&& eval();
														if (!result)
															break out;
													}
			if (result)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		scanner.close();
	}

	static boolean eval() {
		boolean boola = formura();
		pos++;
		boolean boolb = formura();
		return boola == boolb;
	}

	static boolean formura() {
		char cha = equation.charAt(pos);
		pos++;
		switch (cha) {
		case 'T':
			return true;
		case 'F':
			return false;
		case 'a':
			return a == 1;
		case 'b':
			return b == 1;
		case 'c':
			return c == 1;
		case 'd':
			return d == 1;
		case 'e':
			return e == 1;
		case 'f':
			return f == 1;
		case 'g':
			return g == 1;
		case 'h':
			return h == 1;
		case 'i':
			return i == 1;
		case 'j':
			return j == 1;
		case 'k':
			return k == 1;
		case '-':
			return !formura();
		case '(':
			boolean boola = formura();
			char chb = equation.charAt(pos);
			pos++;
			boolean boolb;
			switch (chb) {
			case '*':
				boolb = formura();
				pos++;
				return boola && boolb;
			case '+':
				boolb = formura();
				pos++;
				return boola || boolb;
			case '-':
				pos++;
				boolb = formura();
				pos++;
				return !boola || boolb;
			}
		}
		return false;
	}
}