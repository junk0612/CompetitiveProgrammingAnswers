import java.util.Scanner;

public class Next_Mayor {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int p = sc.nextInt();
			if (n == 0 && p == 0)
				break;
			int[] s = new int[n];
			for (int i = 0; i < n; i++)
				s[i] = 0;
			int i = 0;
			int np = p;
			while (np != s[i]) {
				if (p != 0) {
					p--;
					s[i]++;
				} else if (p == 0) {
					p += s[i];
					s[i] = 0;
				}
				i++;
				if (i >= n)
					i -= n;
			}
			System.out.println(i);
		}
		sc.close();
	}
}
