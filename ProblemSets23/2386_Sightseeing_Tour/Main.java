// Sightseeing Tour
import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[][] c = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				c[i][j] = scanner.nextInt();
		long result = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < i; j++)
				result += Math.min(c[i][j], c[j][i]);
		System.out.println(result);
		scanner.close();
	}
}
