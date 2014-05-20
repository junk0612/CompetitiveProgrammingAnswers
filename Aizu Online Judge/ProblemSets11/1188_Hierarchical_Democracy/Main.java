// Hierarchical Democracy
import java.util.*;

public class Main {
	static int pos;
	static String str;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			pos = 0;
			str = scanner.next();
			int result = formura();
			System.out.println(result);
		}
		scanner.close();
	}

	static int formura() {
		pos++;
		char c = str.charAt(pos);
		int result = 0;
		if (c == '[') {
			List<Integer> numList = new ArrayList<Integer>();
			while (str.charAt(pos) == '[') {
				numList.add(formura());
			}
			Collections.sort(numList);
			for (int i = 0; i < numList.size() / 2 + 1; i++) {
				result += numList.get(i);
			}
		} else {
			while (Character.isDigit(str.charAt(pos))) {
				result *= 10;
				result += Character.getNumericValue(str.charAt(pos));
				pos++;
			}
			result = result / 2 + 1;
		}
		pos++;
		return result;
	}
}
