import java.util.*;

public class The_Secret_Number {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			if (w == 0 && h == 0)
				break;
			String[] str = new String[h];
			for (int i = 0; i < h; i++)
				str[i] = sc.next();
			String[][] field = new String[h][w];
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++)
					field[i][j] = "";
			switch (str[0].charAt(0)) {
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				field[0][0] = str[0].substring(0, 1);
				break;
			default:
				field[0][0] = "";
				break;
			}
			String max = field[0][0];
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++) {
					switch (str[i].charAt(j)) {
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
						if (i > 0) {
							if (field[i - 1][j].equals("")
									|| field[i - 1][j].equals("0"))
								field[i][j] = maxString(field[i][j],
										str[i].substring(j, j + 1));
							else
								field[i][j] = maxString(
										field[i][j],
										field[i - 1][j]
												+ str[i].substring(j, j + 1));
						}
						if (j > 0) {
							if (field[i][j - 1].equals("")
									|| field[i][j - 1].equals("0"))
								field[i][j] = maxString(field[i][j],
										str[i].substring(j, j + 1));
							else
								field[i][j] = maxString(
										field[i][j],
										field[i][j - 1]
												+ str[i].substring(j, j + 1));
						}
						break;
					default:
						field[i][j] = "";
						break;
					}
					max = maxString(max, field[i][j]);
				}
			System.out.println(max);
		}
		sc.close();
	}

	static String maxString(String a, String b) {
		String result = "";
		if (a.length() > b.length())
			result = a;
		if (a.length() < b.length())
			result = b;
		if (a.length() == b.length()) {
			if (a.compareTo(b) < 0)
				result = b;
			else
				result = a;
		}
		return result;
	}
}