// Tax Rate Changed
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int s = sc.nextInt();
			if ((x | y | s) == 0)
				break;
			int result = 0;
			for (int i = 1; i < s; i++)
				for (int j = 1; j < s; j++) {
					int m = i * (100 + x) / 100;
					int n = j * (100 + x) / 100;
					if (m + n == s)
						result = Math.max(result, i * (100 + y) / 100 + j
								* (100 + y) / 100);
				}
			System.out.println(result);
		}
		sc.close();
	}
}
