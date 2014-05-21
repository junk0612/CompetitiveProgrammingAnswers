import java.util.*;

public class Keitai_Message {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			String result = "";
			String str = sc.next();
			String[] strs = str.split("0");
			for (int j = 0; j < strs.length; j++)
				if (strs[j].length() != 0)
					switch (getInt(strs[j].charAt(0))) {
					case 1:
						switch (strs[j].length() % 5) {
						case 1:
							result += ".";
							break;
						case 2:
							result += ",";
							break;
						case 3:
							result += "!";
							break;
						case 4:
							result += "?";
							break;
						case 0:
							result += " ";
							break;
						default:
							break;
						}
						break;
					case 2:
						switch (strs[j].length() % 3) {
						case 1:
							result += "a";
							break;
						case 2:
							result += "b";
							break;
						case 0:
							result += "c";
							break;
						default:
							break;
						}
						break;
					case 3:
						switch (strs[j].length() % 3) {
						case 1:
							result += "d";
							break;
						case 2:
							result += "e";
							break;
						case 0:
							result += "f";
							break;
						default:
							break;
						}
						break;
					case 4:
						switch (strs[j].length() % 3) {
						case 1:
							result += "g";
							break;
						case 2:
							result += "h";
							break;
						case 0:
							result += "i";
							break;
						default:
							break;
						}
						break;
					case 5:
						switch (strs[j].length() % 3) {
						case 1:
							result += "j";
							break;
						case 2:
							result += "k";
							break;
						case 0:
							result += "l";
							break;
						default:
							break;
						}
						break;
					case 6:
						switch (strs[j].length() % 3) {
						case 1:
							result += "m";
							break;
						case 2:
							result += "n";
							break;
						case 0:
							result += "o";
							break;
						default:
							break;
						}
						break;
					case 7:
						switch (strs[j].length() % 4) {
						case 1:
							result += "p";
							break;
						case 2:
							result += "q";
							break;
						case 3:
							result += "r";
							break;
						case 0:
							result += "s";
							break;
						default:
							break;
						}
						break;
					case 8:
						switch (strs[j].length() % 3) {
						case 1:
							result += "t";
							break;
						case 2:
							result += "u";
							break;
						case 0:
							result += "v";
							break;
						default:
							break;
						}
						break;
					case 9:
						switch (strs[j].length() % 4) {
						case 1:
							result += "w";
							break;
						case 2:
							result += "x";
							break;
						case 3:
							result += "y";
							break;
						case 0:
							result += "z";
							break;
						default:
							break;
						}
						break;
					default:
						break;
					}
			System.out.println(result);
		}
		sc.close();
	}

	private static int getInt(char c) {
		return Integer.parseInt(Character.toString(c));
	}
}
