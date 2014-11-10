// King's Inspection
import java.util.Scanner;

public class Main {
	static char[] sta = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
			'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
			'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
			'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W',
			'X', 'Y', 'Z' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int[] keys = new int[n];
			for (int i = 0; i < n; i++)
				keys[i] = sc.nextInt();
			String stations = sc.next();
			StringBuilder result = new StringBuilder();
			for (int i = 0; i < stations.length(); i++) {
				char c = stations.charAt(i);
				int d;
				if (Character.isLowerCase(c))
					d = c - 'a';
				else
					d = c - 'A' + 26;
				d += 52 - keys[i % n];
				d %= 52;
				result.append(sta[d]);
			}
			System.out.println(result);
		}
		sc.close();
	}
}
