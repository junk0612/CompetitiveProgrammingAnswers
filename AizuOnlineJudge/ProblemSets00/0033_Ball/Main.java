// Ball
import java.util.Scanner;

public class Main {
	int[] in;

	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- > 0) {
			in = new int[10];
			for (int i = 0; i < 10; i++)
				in[i] = sc.nextInt();
			if (dfs(0, 0, 0))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
		sc.close();
	}

	boolean dfs(int a, int b, int d) {
		if (d == 9 && (a < in[d] || b < in[d]))
			return true;
		boolean bool = false;
		if (a < in[d])
			bool |= dfs(in[d], b, d + 1);
		if (b < in[d])
			bool |= dfs(a, in[d], d + 1);
		return bool;
	}
}