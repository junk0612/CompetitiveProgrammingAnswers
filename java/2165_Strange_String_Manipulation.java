import java.util.*;

public class Strange_String_Manipulation {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int[] I = new int[n];
			int[] R = new int[n];
			for (int i = 0; i < n; i++)
				I[i] = sc.nextInt();
			int S = 0, A = 0, C = 0;
			double min = Double.MAX_VALUE;
			for (int s = 0; s < 16; s++)
				for (int a = 0; a < 16; a++)
					for (int c = 0; c < 16; c++) {
						int[] O = new int[256];
						R[0] = (a * s + c) % 256;
						O[(I[0] + R[0]) % 256]++;
						for (int i = 1; i < n; i++) {
							R[i] = (a * R[i - 1] + c) % 256;
							O[(I[i] + R[i]) % 256]++;
						}
						double H = 0;
						for (int i = 0; i < 256; i++)
							if (O[i] > 0)
								H -= O[i] / (double) n
										* Math.log(O[i] / (double) n);
						if (H + 1e-10 < min) {
							min = H;
							S = s;
							A = a;
							C = c;
						}
					}
			System.out.println(S + " " + A + " " + C);
		}
		sc.close();
	}
}
