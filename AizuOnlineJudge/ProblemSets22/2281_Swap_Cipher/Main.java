// Ennichi
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			String cipher = sc.next();
			int[] a = new int[n];
			int[] b = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt() - 1;
				b[i] = sc.nextInt() - 1;
			}
			for (int i = n - 1; i >= 0; i--) {
				StringBuilder sb = new StringBuilder();
				int ca = cipher.charAt(a[i]) - 'a';
				int cb = cipher.charAt(b[i]) - 'a';
				int diff = b[i] - a[i];
				ca += diff;
				cb += diff;
				ca %= 26;
				cb %= 26;
				cipher = sb.append(cipher.substring(0, a[i]))
						.append((char) ('a' + cb))
						.append(cipher.substring(a[i] + 1, b[i]))
						.append((char) ('a' + ca))
						.append(cipher.substring(b[i] + 1)).toString();
			}
			System.out.println(cipher);
		}
		sc.close();
	}

}
