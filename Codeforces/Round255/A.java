import java.util.*;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt(), n = sc.nextInt();
		int[] table = new int[p];
		Arrays.fill(table, -1);
		for (int i = 0; i < n; i++) {
			int t = sc.nextInt();
			if (table[t % p] == -1) {
				table[t % p] = t;
				continue;
			}
			System.out.println(i + 1);
			return;
		}
		System.out.println(-1);
	}
}
