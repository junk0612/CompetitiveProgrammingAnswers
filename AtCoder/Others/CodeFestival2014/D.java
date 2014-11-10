import java.util.Scanner;

public class D {
	public static void main(String[] args) {
		new D().run();
	}

	void run() {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		System.out.println((a + 1) + " " + 2);
		sc.close();
	}
}
