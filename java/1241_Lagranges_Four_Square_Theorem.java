import java.util.*;

public class Lagranges_Four_Square_Theorem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] dp = new int[(int) Math.pow(2, 15)];
		for (int i = 0; i * i < dp.length; i++)
			for (int j = i; i * i + j * j < dp.length; j++)
				for (int k = j; i * i + j * j + k * k < dp.length; k++)
					for (int l = k; i * i + j * j + k * k + l * l < dp.length; l++)
						dp[i * i + j * j + k * k + l * l]++;
		int n = sc.nextInt();
		while (n != 0) {
			System.out.println(dp[n]);
			n = sc.nextInt();
		}
		sc.close();
	}
}
