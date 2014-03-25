import java.util.*;

public class Recurring_Decimals {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int a0 = sc.nextInt();
			int l = sc.nextInt();
			if (a0 == 0 && l == 0)
				break;
			Vector<Integer> a = new Vector<Integer>(0);
			a.add(a0);
			while (true) {
				String s = Integer.toString(a0);
				while (s.length() < l)
					s = "0" + s;
				char[] minc = s.toCharArray();
				char[] maxc = s.toCharArray();
				Arrays.sort(minc);
				for (int i = 0; i < l; i++)
					maxc[i] = minc[l - 1 - i];
				int max = Integer.parseInt(String.valueOf(maxc));
				int min = Integer.parseInt(String.valueOf(minc));
				a0 = max - min;
				if (a.contains(a0)) {
					System.out.println(a.indexOf(a0) + " " + a0 + " "
							+ (a.size() - a.indexOf(a0)));
					break;
				}
				a.add(a0);
			}
		}
		sc.close();
	}
}