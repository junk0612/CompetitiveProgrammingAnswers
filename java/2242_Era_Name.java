import java.util.*;

public class MainSix {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int q = sc.nextInt();
			if (n == 0 && q == 0)
				break;
			int[] begin = new int[n];
			int[] end = new int[n];
			String[] era = new String[n];
			for (int i = 0; i < n; i++) {
				era[i] = sc.next();
				int y = sc.nextInt();
				end[i] = sc.nextInt();
				begin[i] = end[i] - y + 1;
			}
			for (int i = 0; i < q; i++) {
				int y = sc.nextInt();
				for (int j = 0; j < n; j++) {
					if (y >= begin[j] && y <= end[j]) {
						System.out.println(era[j] + " " + (y - begin[j] + 1));
						break;
					} else if (j == n - 1)
						System.out.println("Unknown");
				}
			}
		}
		sc.close();
	}
}
