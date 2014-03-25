import java.util.Arrays;
import java.util.Scanner;

public class ICPC_Score_Totalizer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int[] s = new int[n];
			for (int i = 0; i < n; i++)
				s[i] = sc.nextInt();
			Arrays.sort(s);
			int sum = 0;
			for (int i = 1; i < n - 1; i++)
				sum += s[i];
			System.out.println(sum / (n - 2));
		}
		sc.close();
	}
}
