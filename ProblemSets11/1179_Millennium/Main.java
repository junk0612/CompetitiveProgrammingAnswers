import java.util.*;

public class Millennium {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int nowday = 1;
		for (int i = 1; i < 1000; i++) {
			if (i % 3 == 0)
				nowday += 20 * 10;
			else
				nowday += 20 * 5 + 19 * 5;
		}
		for (int i = 0; i < n; i++) {
			int y = sc.nextInt();
			int m = sc.nextInt();
			int d = sc.nextInt();
			int birthday = 0;
			for (int j = 1; j < y; j++) {
				if (j % 3 == 0)
					birthday += (20 * 10);
				else
					birthday += (20 * 5 + 19 * 5);
			}
			for (int j = 1; j < m; j++) {
				if (y % 3 != 0) {
					if (j % 2 == 0)
						birthday += 19;
					else
						birthday += 20;
				} else
					birthday += 20;
			}
			birthday += d;
			System.out.println(nowday - birthday);
		}
		sc.close();
	}
}