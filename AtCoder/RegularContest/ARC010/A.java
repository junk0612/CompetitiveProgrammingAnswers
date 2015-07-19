import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		new Main().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		for (int i = 0; i < m; i++) {
			if (n <= a)
				n += b;
			n -= sc.nextInt();
			if (n < 0) {
				System.out.println(i + 1);
				sc.close();
				return;
			}
		}
		System.out.println("complete");
		sc.close();
	}

}