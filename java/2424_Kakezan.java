import java.util.*;

public class Kakezan {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int q = sc.nextInt();
		for (int z = 0; z < q; z++) {
			int n = sc.nextInt();
			int r = 0;
			while (n / 10 > 0) {
				String s = Integer.toString(n);
				int max = 0;
				for (int i = 1; i < s.length(); i++) {
					int f = Integer.parseInt(s.substring(0, i));
					int e = Integer.parseInt(s.substring(i));
					int l = f * e;
					max = Math.max(max, l);
				}
				n = max;
				r++;
			}
			System.out.println(r);
		}
		sc.close();
	}
}
