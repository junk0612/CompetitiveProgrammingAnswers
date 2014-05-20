import java.util.Scanner;

public class Hanafuda_Shuffle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			int r = sc.nextInt();
			if (n == 0 && r == 0)
				break;
			int[] card = new int[n];
			for (int i = 0; i < n; i++)
				card[i] = n - i;
			for (int i = 0; i < r; i++) {
				int p = sc.nextInt();
				int c = sc.nextInt();
				int[] tcard = new int[p - 1];
				for (int j = 0; j < p - 1; j++)
					tcard[j] = card[j];
				for (int j = 0; j < c; j++)
					card[j] = card[j + p - 1];
				for (int j = 0; j < p - 1; j++)
					card[j + c] = tcard[j];
			}
			System.out.println(card[0]);
		}
		sc.close();
	}
}
