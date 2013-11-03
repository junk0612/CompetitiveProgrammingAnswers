import java.util.*;

public class Sum_of_Consecutive_Integers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int n = sc.nextInt();
			if (n == 0)
				break;
			int result = 0;
			for (int i = 1; i < n; i++) {
				int sum = 0;
				for (int j = i; j < n; j++) {
					sum += j;
					if (sum > n)
						break;
					if (sum == n) {
						result++;
						break;
					}
				}
			}
			System.out.println(result);
		}
		sc.close();
	}
}