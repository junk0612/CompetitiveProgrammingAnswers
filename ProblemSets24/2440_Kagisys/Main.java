import java.util.*;

public class Kagisys {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean lock = true;
		int n = sc.nextInt();
		String[] u = new String[n];
		for (int i = 0; i < n; i++)
			u[i] = sc.next();
		int m = sc.nextInt();
		String[] t = new String[m];
		for (int i = 0; i < m; i++)
			t[i] = sc.next();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (t[i].equals(u[j]) && lock) {
					System.out.println("Opened by " + t[i]);
					lock = false;
					break;
				} else if (t[i].equals(u[j]) && !lock) {
					System.out.println("Closed by " + t[i]);
					lock = true;
					break;
				} else if (j == n - 1)
					System.out.println("Unknown " + t[i]);
			}
		}
		sc.close();
	}
}
