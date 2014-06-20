// The Balance
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int a = sc.nextInt(), b = sc.nextInt(), d = sc.nextInt();
			if ((a | b | d) == 0)
				break;
			int x = 100000, y = 100000;
			for (int i = 0; i <= x + y; i++)
				for (int j = 0; i + j <= x + y; j++) {
					while (a * i - b * j > d)
						j++;
					if (b * j - a * i > d)
						break;
					if (a * i == b * j + d || a * i + b * j == d
							|| b * j == a * i + d) {
						if (i + j < x + y) {
							x = i;
							y = j;
							continue;
						}
						if (i + j == x + y && a * i + b * j < a * x + b * y) {
							x = i;
							y = j;
						}
					}
				}
			System.out.println(x + " " + y);
		}
		sc.close();
	}
}
