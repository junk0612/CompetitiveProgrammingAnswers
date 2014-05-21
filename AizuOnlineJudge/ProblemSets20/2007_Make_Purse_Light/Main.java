import java.util.*;

public class Make_Purse_Light {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean nfirst = false;
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			if (nfirst)
				System.out.println();
			nfirst = true;
			int[] h = new int[4];
			for (int i = 0; i < 4; i++)
				h[i] = sc.nextInt();
			int m = 10 * h[0] + 50 * h[1] + 100 * h[2] + 500 * h[3];
			int r = m - n;
			int[] rs = { 0, 0, 0, 0 };
			while (r >= 500) {
				rs[3]++;
				r -= 500;
			}
			while (r >= 100) {
				rs[2]++;
				r -= 100;
			}
			while (r >= 50) {
				rs[1]++;
				r -= 50;
			}
			while (r >= 10) {
				rs[0]++;
				r -= 10;
			}
			int[] result = new int[4];
			for (int i = 0; i < 4; i++) {
				result[i] = h[i] - rs[i];
				if (result[i] < 0)
					result[i] = 0;
			}
			if (result[0] != 0)
				System.out.println("10 " + result[0]);
			if (result[1] != 0)
				System.out.println("50 " + result[1]);
			if (result[2] != 0)
				System.out.println("100 " + result[2]);
			if (result[3] != 0)
				System.out.println("500 " + result[3]);
		}
		sc.close();
	}
}