import java.util.Scanner;

public class Step_Step_Evolution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			String s = sc.next();
			if (s.equals("#"))
				break;
			char[] c = s.toCharArray();
			int[] n = new int[s.length()];
			for (int i = 0; i < n.length; i++)
				n[i] = (c[i] - '0' - 1) % 3;
			int lf = 0, rf = 2;
			int result = 0;
			boolean foot = true;
			for (int i = 0; i < n.length; i++) {
				if (foot) {
					lf = n[i];
					if (i != 0 && lf > rf) {
						result++;
						rf = lf;
						lf = 0;
						continue;
					}
					foot = false;
					continue;
				}
				rf = n[i];
				if (i != 0 && lf > rf) {
					result++;
					lf = rf;
					rf = 2;
					continue;
				}
				foot = true;
			}
			lf = 0;
			rf = 2;
			foot = false;
			int tresult = 0;
			for (int i = 0; i < n.length; i++) {
				if (foot) {
					lf = n[i];
					if (i != 0 && lf > rf) {
						tresult++;
						rf = lf;
						lf = 0;
						continue;
					}
					foot = false;
					continue;
				}
				rf = n[i];
				if (i != 0 && lf > rf) {
					tresult++;
					lf = rf;
					rf = 2;
					continue;
				}
				foot = true;
			}
			result = Math.min(result, tresult);
			System.out.println(result);
		}
		sc.close();
	}
}
