// Koto Diatance
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		boolean[] width = new boolean[w];
		boolean[] height = new boolean[h];
		Arrays.fill(width, false);
		Arrays.fill(height, false);
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int wi = sc.nextInt();
			for (int j = Math.max(x - wi, 0); j < Math.min(x + wi, w); j++)
				width[j] = true;
			for (int j = Math.max(y - wi, 0); j < Math.min(y + wi, h); j++)
				height[j] = true;
		}
		if (isFilledWithTrue(width) || isFilledWithTrue(height))
			System.out.println("Yes");
		else
			System.out.println("No");
		sc.close();
	}

	private static boolean isFilledWithTrue(boolean[] bool) {
		for (boolean b : bool)
			if (!b)
				return false;
		return true;
	}
}
